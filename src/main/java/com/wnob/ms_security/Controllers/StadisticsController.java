package com.wnob.ms_security.Controllers;

import com.wnob.ms_security.Models.Permission;
import com.wnob.ms_security.Services.ValidatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public/statistics")
public class StadisticsController {
    @Autowired
    private ValidatorsService validatorsService;

    @GetMapping("/mas-veces/{roleId}")
    public ResponseEntity<?> getMostUsedPermissionByRole(@PathVariable String roleId) {
        Permission mostUsedPermission = validatorsService.getMostUsedPermissionByRole(roleId);

        if (mostUsedPermission != null) {
            return ResponseEntity.ok(mostUsedPermission);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron permisos para el rol especificado");
        }
    }
}
