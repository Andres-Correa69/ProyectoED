package proyecto.colpensionex.service;

import java.util.ArrayList;
import java.util.List;

import proyecto.colpensionex.model.Caracterizacion;
import proyecto.colpensionex.model.Cotizante;

public class Validacion {
    private List<Cotizante> listaNegra = new ArrayList<>();
    private List<Caracterizacion> listaCaracterizaciones = new ArrayList<>();

    public void validarCotizantes(List<Cotizante> cotizantes, List<Caracterizacion> caracterizaciones) {
        for (Cotizante cotizante : cotizantes) {

            for (Caracterizacion caracterizacion : caracterizaciones) {
                // Validación 1: Si haEstadoListaNegra es true
                if (cotizante.getHaEstadoListaNegra()) {
                    cotizante.setEstado("rechazado");
                    listaNegra.add(cotizante); // Añadir a lista negra
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
                                        cotizante.setEstado("procesar como civil");
                                    }
                                    break;

                                case "inpec":
                                    if (cotizante.getTieneHijosInpec()) {
                                        cotizante.setEstado("aprobado");
                                    } else if (cotizante.getTieneCondecoracion()) {
                                        cotizante.setEstado("aprobado");
                                    } else {
                                        cotizante.setEstado("procesar como civil");
                                    }
                                    break;

                                case "policía":
                                    if (cotizante.getTieneFamPolicia()) {
                                        if (cotizante.getEsElMayorEdad()) {
                                            cotizante.setEstado("aprobado");
                                        } else {
                                            cotizante.setEstado("procesar como civil");
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

                        } else {
                            // Validación 4: Si perteneceInsPublica es false
                            String ciudadNacimiento = cotizante.getCiudadNacimiento();
                            String ciudadResidencia = cotizante.getCiudadResidencia();

                            if ((ciudadNacimiento.equals("Bogotá") && ciudadResidencia.equals("Bogotá")) ||
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
                    }
                }
            }
        }
    }

    public List<Cotizante> getListaNegra() {
        return listaNegra;
    }
}
