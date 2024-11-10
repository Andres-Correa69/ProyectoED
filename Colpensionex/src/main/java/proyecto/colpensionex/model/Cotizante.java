package proyecto.colpensionex.model;

public class Cotizante{

    //Declaracion de atributos

    private String cedula;
    private String nombre;
    private Integer edad;
    private String correo;
    private String telefono;
    private Boolean haEstadoListaNegra;
    private Boolean esPrePensionado;
    private Boolean perteneceInsPublica;
    private String institucionPublica;
    private Boolean tieneCondecoracion;
    private Boolean tieneHijosInpec;
    private Boolean tieneFamPolicia;
    private Boolean esElMayorEdad;
    private Boolean observacionDisciplinaria;
    private Integer semanas;
    private String ciudadNacimiento;
    private String ciudadResidencia;
    private Boolean alcanzoEdadRPM;
    private String fondo;
    private String estado;

    // Constructor Vacio
    public Cotizante(){

    }

    //Contructor definido

    public Cotizante(String cedula, String nombre, Integer edad, String correo, String telefono,
                   Boolean haEstadoListaNegra, Boolean esPrePensionado, Boolean perteneceInsPublica,
                   String institucionPublica, Boolean tieneCondecoracion, Boolean tieneHijosInpec,
                   Boolean tieneFamPolicia, Boolean esElMayorEdad, Boolean observacionDisciplinaria,
                   Integer semanas, String ciudadNacimiento, String ciudadResidencia,
                   Boolean alcanzoEdadRPM, String fondo, String estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.telefono = telefono;
        this.haEstadoListaNegra = haEstadoListaNegra;
        this.esPrePensionado = esPrePensionado;
        this.perteneceInsPublica = perteneceInsPublica;
        this.institucionPublica = institucionPublica;
        this.tieneCondecoracion = tieneCondecoracion;
        this.tieneHijosInpec = tieneHijosInpec;
        this.tieneFamPolicia = tieneFamPolicia;
        this.esElMayorEdad = esElMayorEdad;
        this.observacionDisciplinaria = observacionDisciplinaria;
        this.semanas = semanas;
        this.ciudadNacimiento = ciudadNacimiento;
        this.ciudadResidencia = ciudadResidencia;
        this.alcanzoEdadRPM = alcanzoEdadRPM;
        this.fondo = fondo;
        this.estado = estado;
    }

    //getters and setters


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getHaEstadoListaNegra() {
        return haEstadoListaNegra;
    }

    public void setHaEstadoListaNegra(Boolean haEstadoListaNegra) {
        this.haEstadoListaNegra = haEstadoListaNegra;
    }

    public Boolean getEsPrePensionado() {
        return esPrePensionado;
    }

    public void setEsPrePensionado(Boolean esPrePensionado) {
        this.esPrePensionado = esPrePensionado;
    }

    public Boolean getPerteneceInsPublica() {
        return perteneceInsPublica;
    }

    public void setPerteneceInsPublica(Boolean perteneceInsPublica) {
        perteneceInsPublica = perteneceInsPublica;
    }

    public String getInstitucionPublica() {
        return institucionPublica;
    }

    public void setInstitucionPublica(String institucionPublica) {
        this.institucionPublica = institucionPublica;
    }

    public Boolean getTieneCondecoracion() {
        return tieneCondecoracion;
    }

    public void setTieneCondecoracion(Boolean tieneCondecoracion) {
        this.tieneCondecoracion = tieneCondecoracion;
    }

    public Boolean getTieneHijosInpec() {
        return tieneHijosInpec;
    }

    public void setTieneHijosInpec(Boolean tieneHijosInpec) {
        this.tieneHijosInpec = tieneHijosInpec;
    }

    public Boolean getTieneFamPolicia() {
        return tieneFamPolicia;
    }

    public void setTieneFamPolicia(Boolean tieneFamPolicia) {
        this.tieneFamPolicia = tieneFamPolicia;
    }

    public Boolean getEsElMayorEdad() {
        return esElMayorEdad;
    }

    public void setEsElMayorEdad(Boolean esElMayorEdad) {
        this.esElMayorEdad = esElMayorEdad;
    }

    public Boolean getObservacionDisciplinaria() {
        return observacionDisciplinaria;
    }

    public void setObservacionDisciplinaria(Boolean observacionDisciplinaria) {
        this.observacionDisciplinaria = observacionDisciplinaria;
    }

    public Integer getSemanas() {
        return semanas;
    }

    public void setSemanas(Integer semanas) {
        this.semanas = semanas;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(String ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public Boolean getAlcanzoEdadRPM() {
        return alcanzoEdadRPM;
    }

    public void setAlcanzoEdadRPM(Boolean alcanzoEdadRPM) {
        this.alcanzoEdadRPM = alcanzoEdadRPM;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //metodo toString
    @Override
    public String toString() {
        return "Cédula: " + cedula + " | Nombre: " + nombre + " | Edad: " + edad + " | Correo: " + correo + " | Télefono: " + telefono + " | ¿Ha Estado en la Lista Negra?: " + haEstadoListaNegra + " | ¿Es Pre-Pensionado?: " + esPrePensionado + " | ¿Pertenece a una Institución Pública?: " + perteneceInsPublica + " | ¿Cuál?: " + institucionPublica + " | ¿Tiene Condecoraciones?: " + tieneCondecoracion + " | ¿Tiene Hijos en el Inpec?: " + tieneHijosInpec + " | ¿Tiene Familiares Policias?: " + tieneFamPolicia + " | ¿Es Usted el Mayor?: " + esElMayorEdad + " | ¿Tiene Observaciones Disciplinarias?: " + observacionDisciplinaria + " | ¿Cuántas Semanas Tiene Cotizadas?: " + semanas + " | Ciudad de Nacimiento: " + ciudadNacimiento + " | Ciudad de Residencia: " + ciudadResidencia + " | ¿Alcanzó la Edad para RPM?: " + alcanzoEdadRPM + " | Fondo: " + fondo + " | Estado: " + estado;
    }
}
