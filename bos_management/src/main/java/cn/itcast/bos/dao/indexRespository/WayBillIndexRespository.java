package cn.itcast.bos.dao.indexRespository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.itcast.bos.domain.take_delivery.WayBill;

public interface WayBillIndexRespository extends ElasticsearchRepository<WayBill, Integer>{

}
