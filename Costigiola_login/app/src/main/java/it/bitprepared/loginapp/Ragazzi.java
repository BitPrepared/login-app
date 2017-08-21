package it.bitprepared.loginapp;

public class Ragazzi {
    final static String Rossi = "Phoenix";
    final static String Bianchi = "Ikarus";
    final static String Verdi = "Legacy";
//    static String Gialli = "Gialli";

    private final String nome;
    private final String cognome;
    String sq;

    Ragazzi(String nome, String cognome, String sq) {
        this.nome = nome;
        this.cognome = cognome;
        this.sq = sq;
    }

    Ragazzi(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ragazzi other = (Ragazzi) obj;
        if (cognome == null) {
            if (other.cognome != null)
                return false;
        } else if (!cognome.toLowerCase().replace(" ", "").equals(other.cognome.toLowerCase().replace(" ", "")))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.toLowerCase().replace(" ", "").equals(other.nome.toLowerCase().replace(" ", "")))
            return false;
        return true;
    }


}
