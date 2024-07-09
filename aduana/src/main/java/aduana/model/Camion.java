package aduana.model;


    public class Camion {
                
        private int id_camion;
        private String nombreEmpresa;
        private String tipoCarga;
        private String paisOrigen;
        private String paisDestino;
        private boolean acoplado;
        private double pesoCarga;
        private Conductor conductor;
        
    
        public Camion() {
        }


        public Camion(int id, String nombreEmpresa, String tipoCarga, String paisOrigen, String paisDestino,
                boolean acoplado, double pesoCarga, Conductor conductor) {
            this.id_camion = id;
            this.nombreEmpresa = nombreEmpresa;
            this.tipoCarga = tipoCarga;
            this.paisOrigen = paisOrigen;
            this.paisDestino = paisDestino;
            this.acoplado = acoplado;
            this.pesoCarga = pesoCarga;
            this.conductor = conductor;
        }


        public int getId() {
            return id_camion;
        }


        public void setId(int id) {
            this.id_camion = id;
        }


        public String getNombreEmpresa() {
            return nombreEmpresa;
        }


        public void setNombreEmpresa(String nombreEmpresa) {
            this.nombreEmpresa = nombreEmpresa;
        }


        public String getTipoCarga() {
            return tipoCarga;
        }


        public void setTipoCarga(String tipoCarga) {
            this.tipoCarga = tipoCarga;
        }


        public String getPaisOrigen() {
            return paisOrigen;
        }


        public void setPaisOrigen(String paisOrigen) {
            this.paisOrigen = paisOrigen;
        }


        public String getPaisDestino() {
            return paisDestino;
        }


        public void setPaisDestino(String paisDestino) {
            this.paisDestino = paisDestino;
        }


        public boolean isAcoplado() {
            return acoplado;
        }


        public void setAcoplado(boolean acoplado) {
            this.acoplado = acoplado;
        }


        public double getPesoCarga() {
            return pesoCarga;
        }


        public void setPesoCarga(double pesoCarga) {
            this.pesoCarga = pesoCarga;
        }


        public Conductor getConductor() {
            return conductor;
        }


        public void setConductor(Conductor conductor) {
            this.conductor = conductor;
        }

        public String toString() {
            return "Camion: " +
            "\n  id=" + id_camion +
            "\n  nombreEmpresa='" + nombreEmpresa + '\'' +
            "\n  tipoCarga='" + tipoCarga + '\'' +
            "\n  paisOrigen='" + paisOrigen + '\'' +
            "\n  paisDestino='" + paisDestino + '\'' +
            "\n  acoplado=" + acoplado +
            "\n  pesoCarga=" + pesoCarga +
            "\n Conductor asignado: "+
            "\n  conductor=" + (conductor != null ? conductor.toString() : "null") +
            "\n}";
        
    }}


