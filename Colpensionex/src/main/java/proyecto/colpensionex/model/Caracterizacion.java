package proyecto.colpensionex.model;

public class Caracterizacion {

    private String cedula;
    private Boolean embargado;
    private Boolean inhabilitado;

    public Caracterizacion(){

    }

    public Caracterizacion(String cedula, Boolean embargado, Boolean inhabilitado){

        this.cedula = cedula;
        this.embargado = embargado;
        this.inhabilitado = inhabilitado;

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Boolean getEmbargado() {
        return embargado;
    }

    public void setEmbargado(Boolean embargado) {
        this.embargado = embargado;
    }

    public Boolean getInhabilitado() {
        return inhabilitado;
    }

    public void setInhabilitado(Boolean inhabilitado) {
        this.inhabilitado = inhabilitado;
    }


    @Override
    public String toString() {
        return "Caracterizacion{" +
                "cedula='" + cedula + '\'' +
                ", embargado=" + embargado +
                ", inhabilitado=" + inhabilitado +
                '}';
    }
}
