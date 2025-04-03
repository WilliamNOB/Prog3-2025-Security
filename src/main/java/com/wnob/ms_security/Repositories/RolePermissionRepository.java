package com.wnob.ms_security.Repositories;

import com.wnob.ms_security.Models.Permission;
import com.wnob.ms_security.Models.RolePermission;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RolePermissionRepository extends MongoRepository<RolePermission, String> {
    @Query("{'role.$id': ObjectId(?0)}")
    List<RolePermission> getPermissionsByRole(String roleId);
    @Query("{'role.$id': ObjectId(?0),'permission.$id': ObjectId(?1)}")
    public RolePermission getRolePermission(String roleId,String permissionId);

    @Aggregation(pipeline = {
            "{ $match: { 'role.$id': ObjectId(?0) } }",
            "{ $group: { _id: '$permission', count: { $sum: 1 } } }",
            "{ $sort: { count: -1 } }",
            "{ $limit: 1 }",
            "{ $lookup: { from: 'permissions', localField: '_id.$id', foreignField: '_id', as: 'permission' } }",
            "{ $unwind: '$permission' }"
    })
    List<PermissionUsage> findMostUsedPermissionByRole(String roleId);

    public interface PermissionUsage {
        Permission getPermission();
        int getCount();
    }
}
