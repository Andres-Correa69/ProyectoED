package proyecto.colpensionex.service;


import proyecto.colpensionex.model.Caracterizacion;
import proyecto.colpensionex.model.Cotizante;

import java.util.ArrayList;
import java.util.List;

public class Validacion {
    private List<Cotizante> listaNegra = new ArrayList<>();
    private List<Cotizante> listaRechazados = new ArrayList<>();
    private List<Cotizante> listaInhabilitados = new ArrayList<>();
    private List<Cotizante> listaEmbargados = new ArrayList<>();
    private List<Cotizante> listaAceptados = new ArrayList<>();

    public void validarCotizantes(List<Cotizante> cotizantes, List<Caracterizacion> caracterizaciones) {
        for (Cotizante cotizante : cotizantes) {
            for (Caracterizacion caracterizacion : caracterizaciones) {
                if(caracterizacion.getCedula().equals(cotizante.getCedula())) {
                    if (caracterizacion.getEmbargado()){
                        cotizante.setEstado("embargado");
                        break;
                    } else if(caracterizacion.getInhabilitado()){
                        cotizante.setEstado("inhabilitado");
                        break;
                    }
                }
                // Validación 1: Si haEstadoListaNegra es true
                if (cotizante.getHaEstadoListaNegra()) {
                    cotizante.setEstado("lista negra");
                     // Añadir a lista negra
                } else {
                    // Validación 2: Si esPrePensionado es true
                    if (cotizante.getEsPrePensionado()) {
                        cotizante.setEstado("rechazado");
                    } else {
                        // Validación 3: Si perteneceInsPublica es true
                        if (cotizante.getPerteneceInsPublica()) {
                            String institucion = cotizante.getInstitucionPublica();

                            switch (institucion.toLowerCase()) {
                                case "armada":
                                    if (cotizante.getTieneCondecoracion()) {
                                        cotizante.setEstado("aprobado");
                                    } else {
                                       // cotizante.setEstado("procesar como civil");
                                        validacionCivil(cotizante);
                                    }
                                    break;

                                case "inpec":
                                    if (cotizante.getTieneHijosInpec()) {
                                        cotizante.setEstado("aprobado");
                                    } else if (cotizante.getTieneCondecoracion()) {
                                        cotizante.setEstado("aprobado");
                                    } else {
                                       // cotizante.setEstado("procesar como civil");
                                        validacionCivil(cotizante);
                                    }
                                    break;

                                case "policía":
                                    if (cotizante.getTieneFamPolicia()) {
                                        if (cotizante.getEsElMayorEdad()) {
                                            cotizante.setEstado("aprobado");
                                        } else {
                                           // cotizante.setEstado("procesar como civil");
                                            validacionCivil(cotizante);
                                        }
                                    } else {
                                        cotizante.setEstado("rechazado");
                                    }
                                    break;

                                case "minsalud", "mininterior":
                                    if (cotizante.getObservacionDisciplinaria()) {
                                        cotizante.setEstado("aprobado");
                                    } else {
                                        cotizante.setEstado("rechazado");
                                        cotizante.setHaEstadoListaNegra(true);
                                        listaNegra.add(cotizante); // Añadir a lista negra
                                    }
                                    break;

                                default:
                                    break;
                            }

                        } else { validacionCivil(cotizante);

                        }
                    }
                }
            }
        }
    }

    public static void validacionCivil(Cotizante cotizante) {
        // Validación 4: Si perteneceInsPublica es false
        String ciudadNacimiento = cotizante.getCiudadNacimiento();
        String ciudadResidencia = cotizante.getCiudadResidencia();

        if ((ciudadNacimiento.equals("Bogotá, D.C.") && ciudadResidencia.equals("Bogotá, D.C.")) ||
                (ciudadNacimiento.equals("Medellin") && ciudadResidencia.equals("Medellin")) ||
                (ciudadNacimiento.equals("Cali") && ciudadResidencia.equals("Cali"))) {
            cotizante.setEstado("rechazado");

        } else if (cotizante.getAlcanzoEdadRPM()) {
            cotizante.setEstado("rechazado");
        } else {
            // Validación del fondo de origen
            String fondo = cotizante.getFondo();

            switch (fondo.toLowerCase()) {
                case "extranjero":
                    cotizante.setEstado("aprobado");
                    break;

                case "porvenir":
                    if (cotizante.getSemanas() < 800) {
                        cotizante.setEstado("aprobado");
                    } else {
                        cotizante.setEstado("rechazado");
                    }
                    break;

                case "protección":
                    if (cotizante.getSemanas() < 590) {
                        cotizante.setEstado("aprobado");
                    } else {
                        cotizante.setEstado("rechazado");
                    }
                    break;

                case "colfondos":
                    if (cotizante.getSemanas() < 300) {
                        cotizante.setEstado("aprobado");
                    } else {
                        cotizante.setEstado("rechazado");
                    }
                    break;
                case "oldmutual":
                    if (cotizante.getSemanas() < 100) {
                        cotizante.setEstado("aprobado");
                    } else {
                        cotizante.setEstado("rechazado");
                    }
                    break;

                default:
                    break;
            }
        }
    }

    public void rellenarListas(List<Cotizante> cotizantes){
        for(Cotizante cotizante : cotizantes){
            if(cotizante.getEstado().equals("aprobado")){
                listaAceptados.add(cotizante);
            }
            if(cotizante.getEstado().equals("rechazado")){
                listaRechazados.add(cotizante);
            }
            if(cotizante.getEstado().equals("inhabilitado")){
                listaInhabilitados.add(cotizante);
            }
            if(cotizante.getEstado().equals("embargado")){
                listaEmbargados.add(cotizante);
            }
            if(cotizante.getEstado().equals("lista negra")){
                listaNegra.add(cotizante);
            }
        }

    }

    public List<Cotizante> getListaNegra() {
        return listaNegra;
    }

    public void setListaNegra(List<Cotizante> listaNegra) {
        this.listaNegra = listaNegra;
    }

    public List<Cotizante> getListaRechazados() {
        return listaRechazados;
    }

    public void setListaRechazados(List<Cotizante> listaRechazados) {
        this.listaRechazados = listaRechazados;
    }

    public List<Cotizante> getListaInhabilitados() {
        return listaInhabilitados;
    }

    public void setListaInhabilitados(List<Cotizante> listaInhabilitados) {
        this.listaInhabilitados = listaInhabilitados;
    }

    public List<Cotizante> getListaEmbargados() {
        return listaEmbargados;
    }

    public void setListaEmbargados(List<Cotizante> listaEmbargados) {
        this.listaEmbargados = listaEmbargados;
    }

    public List<Cotizante> getListaAceptados() {
        return listaAceptados;
    }

    public void setListaAceptados(List<Cotizante> listaAceptados) {
        this.listaAceptados = listaAceptados;
    }
}