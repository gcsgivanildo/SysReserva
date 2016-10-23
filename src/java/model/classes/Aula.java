
package model.classes;

import java.util.Calendar;




public class Aula {
    private int idAula;
    private Calendar data;
    private Calendar hora;
    private int duracao;
    private int idSiape;
    private int idSala;
    private int idItemEquipamento;

    public int getIdSiape() {
        return idSiape;
    }

    public void setIdSiape(int idSiape) {
        this.idSiape = idSiape;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getIdItemEquipamento() {
        return idItemEquipamento;
    }

    public void setIdItemEquipamento(int idItemEquipamento) {
        this.idItemEquipamento = idItemEquipamento;
    }

    public int getIdAula() {
        return idAula;
    }

    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Calendar getHora() {
        return hora;
    }

    public void setHora(Calendar hora) {
        this.hora = hora;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
}
