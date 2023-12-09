package com.example.app.repository;

import com.example.app.entity.Departamento;
import com.example.app.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpleadoRepository  extends JpaRepository<Empleado, Long> {

    Empleado findByEmail(String email);

    List<Empleado> findBySalarioGreaterThanEqualOrderBySalario (double salario);
    List<Empleado> findByDepartamento (Departamento departamento);

    @Query("select e from Empleado e where e.id=(select max(e2.id) from Empleado e2)")
    Empleado obtenerMaxIdEmpleado();
    @Query("select e from Empleado e " +
            "where e.salario > (select avg (e2.salario) from Empleado e2)")
    List <Empleado> obtenerEmpleadoSalarioMayorMedia();


}
