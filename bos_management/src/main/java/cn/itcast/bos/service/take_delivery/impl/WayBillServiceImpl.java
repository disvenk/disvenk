package cn.itcast.bos.service.take_delivery.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder.Operator;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.bos.dao.base.WayBillRespository;
import cn.itcast.bos.dao.indexRespository.WayBillIndexRespository;
import cn.itcast.bos.domain.take_delivery.WayBill;
import cn.itcast.bos.service.take_delivery.WayBillService;

@Service
@Transactional
public class WayBillServiceImpl implements WayBillService {

	@Autowired
	private WayBillRespository wayBillRespository;
	@Autowired
	private WayBillIndexRespository wayBillIndexRespository;
	
	//保存运单
	@Override
	public void save(WayBill wayBill) {
		// 判断运单号是否存在
				WayBill persistWayBill = wayBillRespository.findByWayBillNum(wayBill
						.getWayBillNum());
				if (persistWayBill == null || persistWayBill.getId() == null) {
					// 运单不存在
					wayBillRespository.save(wayBill);
					//保存索引，这里使用了框架，直接传过来一个对象进行保存即可
					wayBillIndexRespository.save(wayBill);
				} else {
					// 运单存在
					try {
						if(persistWayBill.getSignStatus()==1){
						//这里没有使用到save,解释一次缓存和快照
						Integer id = persistWayBill.getId();
						BeanUtils.copyProperties(persistWayBill, wayBill);
						persistWayBill.setId(id);
						//保存索引
						wayBillIndexRespository.save(persistWayBill);
						}else{
							throw new RuntimeException("运单已发出，无法修改保存");
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException(e.getMessage());
					}
					
				}
	}

	//分页查询运单，基础部分的事情我们不要去管，我么直接使用框架，对于海量的数据，我们通过在Javabean上
	//增添了映射信息后，我们就可以在这里将它指定的属性作为查询条件即可，至于是怎么实现的我们主要了解他的几个概念
	//索引对象，文档类型，文档，映射
	@Override
	public Page<WayBill> findPageData(WayBill wayBill,Pageable pageable) {
		// 判断WayBill 中条件是否存在
				if (StringUtils.isBlank(wayBill.getWayBillNum())
						&& StringUtils.isBlank(wayBill.getSendAddress())
						&& StringUtils.isBlank(wayBill.getRecAddress())
						&& StringUtils.isBlank(wayBill.getSendProNum())
						&& (wayBill.getSignStatus() == null || wayBill.getSignStatus() == 0)) {
					// 无条件查询 、查询数据库
					return wayBillRespository.findAll(pageable);
				} else {
					// 查询条件
					// must 条件必须成立 and
					// must not 条件必须不成立 not
					// should 条件可以成立 or
					BoolQueryBuilder query = new BoolQueryBuilder(); // 布尔查询 ，多条件组合查询
					//布尔查询可以将多个查询的条件连接起来，must是and的意思，should是or的意思
					// 向组合查询对象添加条件
					if (StringUtils.isNoneBlank(wayBill.getWayBillNum())) {
						// 运单号查询
						QueryBuilder tempQuery = new TermQueryBuilder("wayBillNum",
								wayBill.getWayBillNum());
						query.must(tempQuery);
					}
					if (StringUtils.isNoneBlank(wayBill.getSendAddress())) {
						// 发货地 模糊查询
						// 情况一： 输入"北" 是查询词条一部分， 使用模糊匹配词条查询
						QueryBuilder wildcardQuery = new WildcardQueryBuilder(
								"sendAddress", "*" + wayBill.getSendAddress() + "*");

						// 情况二： 输入"北京市海淀区" 是多个词条组合，进行分词后 每个词条匹配查询
						QueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(
								wayBill.getSendAddress()).field("sendAddress")
								.defaultOperator(Operator.AND);

						// 两种情况取or关系
						BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
						boolQueryBuilder.should(wildcardQuery);
						boolQueryBuilder.should(queryStringQueryBuilder);

						//这里使用了布尔的嵌套，说明or的内面还有or的话,我们还是要用布尔连接
						query.must(boolQueryBuilder);
					}
					if (StringUtils.isNoneBlank(wayBill.getRecAddress())) {
						// 收货地 模糊查询
						QueryBuilder wildcardQuery = new WildcardQueryBuilder(
								"recAddress", "*" + wayBill.getRecAddress() + "*");
						query.must(wildcardQuery);
					}
					if (StringUtils.isNoneBlank(wayBill.getSendProNum())) {
						// 速运类型 等值查询
						QueryBuilder termQuery = new TermQueryBuilder("sendProNum",
								wayBill.getSendProNum());
						query.must(termQuery);
					}
					if (StringUtils.isNoneBlank(wayBill.getSendProNum())) {
						// 速运类型 等值查询
						QueryBuilder termQuery = new TermQueryBuilder("sendProNum",
								wayBill.getSendProNum());
						query.must(termQuery);
					}
					if (wayBill.getSignStatus() != null && wayBill.getSignStatus() != 0) {
						// 签收状态查询
						QueryBuilder termQuery = new TermQueryBuilder("signStatus",
								wayBill.getSignStatus());
						query.must(termQuery);
					}
					
					//这是个额外新开的对象，将连接了多个查询条件的布尔对象传入里面
					SearchQuery searchQuery = new NativeSearchQuery(query);
					
					searchQuery.setPageable(pageable); // 分页效果
					//还要把分页对象set进去
					
					// 有条件查询 、查询索引库
					return wayBillIndexRespository.search(searchQuery);
				}
	}

	@Override
	public WayBill findByWayBillNum(String wayBillNum) {
		return wayBillRespository.findByWayBillNum(wayBillNum);
	}

	//同步索引
	@Override
	public void syncIndex() {
	List<WayBill> list = wayBillRespository.findAll();
	wayBillIndexRespository.save(list);
	System.out.println("执行了运单索引的同步更新");
		
	}

	//导出查询
	@Override
	public List<WayBill> findWayBills(WayBill wayBill) {
		// 判断WayBill 中条件是否存在
		if (StringUtils.isBlank(wayBill.getWayBillNum())
				&& StringUtils.isBlank(wayBill.getSendAddress())
				&& StringUtils.isBlank(wayBill.getRecAddress())
				&& StringUtils.isBlank(wayBill.getSendProNum())
				&& (wayBill.getSignStatus() == null || wayBill.getSignStatus() == 0)) {
			// 无条件查询 、查询数据库，要导出所有的就不用分页了
			return wayBillRespository.findAll();
		} else {
			// 查询条件
			// must 条件必须成立 and
			// must not 条件必须不成立 not
			// should 条件可以成立 or
			BoolQueryBuilder query = new BoolQueryBuilder(); // 布尔查询 ，多条件组合查询
			//布尔查询可以将多个查询的条件连接起来，must是and的意思，should是or的意思
			// 向组合查询对象添加条件
			if (StringUtils.isNoneBlank(wayBill.getWayBillNum())) {
				// 运单号查询
				QueryBuilder tempQuery = new TermQueryBuilder("wayBillNum",
						wayBill.getWayBillNum());
				query.must(tempQuery);
			}
			if (StringUtils.isNoneBlank(wayBill.getSendAddress())) {
				// 发货地 模糊查询
				// 情况一： 输入"北" 是查询词条一部分， 使用模糊匹配词条查询
				QueryBuilder wildcardQuery = new WildcardQueryBuilder(
						"sendAddress", "*" + wayBill.getSendAddress() + "*");

				// 情况二： 输入"北京市海淀区" 是多个词条组合，进行分词后 每个词条匹配查询
				QueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(
						wayBill.getSendAddress()).field("sendAddress")
						.defaultOperator(Operator.AND);

				// 两种情况取or关系
				BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
				boolQueryBuilder.should(wildcardQuery);
				boolQueryBuilder.should(queryStringQueryBuilder);

				//这里使用了布尔的嵌套，说明or的内面还有or的话,我们还是要用布尔连接
				query.must(boolQueryBuilder);
			}
			if (StringUtils.isNoneBlank(wayBill.getRecAddress())) {
				// 收货地 模糊查询
				QueryBuilder wildcardQuery = new WildcardQueryBuilder(
						"recAddress", "*" + wayBill.getRecAddress() + "*");
				query.must(wildcardQuery);
			}
			if (StringUtils.isNoneBlank(wayBill.getSendProNum())) {
				// 速运类型 等值查询
				QueryBuilder termQuery = new TermQueryBuilder("sendProNum",
						wayBill.getSendProNum());
				query.must(termQuery);
			}
			if (StringUtils.isNoneBlank(wayBill.getSendProNum())) {
				// 速运类型 等值查询
				QueryBuilder termQuery = new TermQueryBuilder("sendProNum",
						wayBill.getSendProNum());
				query.must(termQuery);
			}
			if (wayBill.getSignStatus() != null && wayBill.getSignStatus() != 0) {
				// 签收状态查询
				QueryBuilder termQuery = new TermQueryBuilder("signStatus",
						wayBill.getSignStatus());
				query.must(termQuery);
			}
			
			//这是个额外新开的对象，将连接了多个查询条件的布尔对象传入里面
			SearchQuery searchQuery = new NativeSearchQuery(query);
			//创建新的分页对象让它不分页查询所有的数据
			Pageable pageable = new PageRequest(0,Integer.MAX_VALUE);
			searchQuery.setPageable(pageable); // 分页效果
			//还要把分页对象set进去
			
			// 有条件查询 、查询索引库
			return wayBillIndexRespository.search(searchQuery).getContent();
		}
	}

}
