package com.example.demo.service;

import com.example.demo.model.Vacante;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class VacantesServiceImpl implements IVacantesService {

    private List<Vacante> vacantes;

    public VacantesServiceImpl() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        vacantes = new LinkedList<Vacante>();

        Vacante vacante1 = new Vacante();
        Vacante vacante2 = new Vacante();
        Vacante vacante3 = new Vacante();
        Vacante vacante4 = new Vacante();

        try {
            vacante1.setId(1);
            vacante1.setNombre("Ingeniero Civil");
            vacante1.setDescripcion("Se necesita ingeniero civil para diseñar puente peatonal.");
            vacante1.setSalario(14000.0);
            vacante1.setFecha( sdf.parse("08-02-2019") );
            vacante1.setDestacado(1);
            vacante1.setImagen("logo1.png");

            vacante2.setId(2);
            vacante2.setNombre("Contador publico");
            vacante2.setDescripcion("Empresa importante solicita contador publico con 5 años de experiencia titulado.");
            vacante2.setSalario(12000.0);
            vacante2.setFecha( sdf.parse("09-02-2019") );
            vacante2.setDestacado(0);
            vacante2.setImagen("logo2.png");

            vacante3.setId(3);
            vacante3.setNombre("Ingeniero Electrico");
            vacante3.setDescripcion("Empresa internacional solicita ingeniero electrico para mantenimiento de la instalacion electrica");
            vacante3.setSalario(10500.0);
            vacante3.setFecha( sdf.parse("10-02-2019") );
            vacante3.setDestacado(0);
            vacante3.setImagen("logo3.png");

            vacante4.setId(4);
            vacante4.setNombre("Diseñador Gráfico");
            vacante4.setDescripcion("Solicitamos diseñador gráfico titulado para diseñar publicidad de la empresa");
            vacante4.setSalario(7500.0);
            vacante4.setFecha( sdf.parse("11-02-2019") );
            vacante4.setDestacado(1);
            vacante4.setImagen("logo4.png");

            vacantes.add(vacante1);
            vacantes.add(vacante2);
            vacantes.add(vacante3);
            vacantes.add(vacante4);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vacante> buscarTodas() {
        return vacantes;
    }

    @Override
    public Vacante buscarPorId(Integer id) {
        for( Vacante vacante : vacantes ) {
            if( vacante.getId().equals(id) ) {
                return vacante;
            }
        }
        return null;
    }

    @Override
    public void guardar(Vacante vacante) {
        vacantes.add(vacante);
    }
}
