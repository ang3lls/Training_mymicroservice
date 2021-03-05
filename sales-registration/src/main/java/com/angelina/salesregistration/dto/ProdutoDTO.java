package com.angelina.salesregistration.dto;


public class ProdutoDTO {
    private Integer id;
    private Integer quantidade;
    private String descricao;
    private float valoUnitario;

    public ProdutoDTO(Integer id, Integer quantidade, String descricao, float valoUnitario) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valoUnitario = valoUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
