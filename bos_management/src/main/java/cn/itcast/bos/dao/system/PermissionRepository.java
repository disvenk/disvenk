package cn.itcast.bos.dao.system;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.itcast.bos.domain.system.Permission;

public interface PermissionRepository extends
		JpaRepository<Permission, Integer> {

	//先根据用户去查角色，返回一个用户关联的角色的集合，然后在通过角色去查询角色所具有的权限
	@Query("from Permission p inner join fetch p.roles r inner join fetch r.users u where u.id =? ")
	List<Permission> findByUser(Integer id);

}
