package it.bitprepared.loginapp;

public class Ragazzi {
    public static String Rossi = "Rossi";
    public static String Bianchi = "Bianchi";
    public static String Verdi = "Verdi";
    public static String Gialli = "Gialli";

    String nome;
    String cognome;
    String sq;

    public Ragazzi(String nome, String cognome, String sq) {
        this.nome = nome;
        this.cognome = cognome;
        this.sq = sq;
    }

    public Ragazzi(String nome, String cognome) {
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
        } else if (!cognome.equals(other.cognome))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }


}
