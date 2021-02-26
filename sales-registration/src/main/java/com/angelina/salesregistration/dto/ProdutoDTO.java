package com.angelina.salesregistration.dto;

public class ProdutoDTO {
    private int id;
    private String descricao;
    private float valoUnitario;

    public ProdutoDTO(int id, String descricao, float valoUnitario) {
        this.id = id;
        this.descricao = descricao;
        this.valoUnitario = valoUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValoUnitario() {
        return valoUnitario;
    }

    public void setValoUnitario(float valoUnitario) {
        this.valoUnitario = valoUnitario;
    }
}
