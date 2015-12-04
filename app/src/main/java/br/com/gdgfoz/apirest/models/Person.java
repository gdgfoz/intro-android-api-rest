package br.com.gdgfoz.apirest.models;

/**
 * Created by hussan on 12/3/15.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("nome")
    @Expose
    private String nome;
    @SerializedName("foto")
    @Expose
    private String foto;
    @SerializedName("data_des")
    @Expose
    private String dataDes;
    @SerializedName("cidade")
    @Expose
    private String cidade;
    @SerializedName("estado")
    @Expose
    private String estado;
    @SerializedName("feito_boletim")
    @Expose
    private String feitoBoletim;
    @SerializedName("sexo")
    @Expose
    private String sexo;
    @SerializedName("idade_des")
    @Expose
    private String idadeDes;
    @SerializedName("transtorno_mental")
    @Expose
    private String transtornoMental;
    @SerializedName("tipo_fisico")
    @Expose
    private String tipoFisico;
    @SerializedName("pele")
    @Expose
    private String pele;
    @SerializedName("peso")
    @Expose
    private String peso;
    @SerializedName("altura")
    @Expose
    private String altura;
    @SerializedName("olhos")
    @Expose
    private String olhos;
    @SerializedName("cabelos")
    @Expose
    private String cabelos;
    @SerializedName("data_registro")
    @Expose
    private String dataRegistro;
    @SerializedName("data_atualizacao")
    @Expose
    private String dataAtualizacao;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("situacao")
    @Expose
    private String situacao;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     * The nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     * The foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     *
     * @param foto
     * The foto
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     *
     * @return
     * The dataDes
     */
    public String getDataDes() {
        return dataDes;
    }

    /**
     *
     * @param dataDes
     * The data_des
     */
    public void setDataDes(String dataDes) {
        this.dataDes = dataDes;
    }

    /**
     *
     * @return
     * The cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @param cidade
     * The cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @return
     * The estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     * The estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     * The feitoBoletim
     */
    public String getFeitoBoletim() {
        return feitoBoletim;
    }

    /**
     *
     * @param feitoBoletim
     * The feito_boletim
     */
    public void setFeitoBoletim(String feitoBoletim) {
        this.feitoBoletim = feitoBoletim;
    }

    /**
     *
     * @return
     * The sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     *
     * @param sexo
     * The sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     *
     * @return
     * The idadeDes
     */
    public String getIdadeDes() {
        return idadeDes;
    }

    /**
     *
     * @param idadeDes
     * The idade_des
     */
    public void setIdadeDes(String idadeDes) {
        this.idadeDes = idadeDes;
    }

    /**
     *
     * @return
     * The transtornoMental
     */
    public String getTranstornoMental() {
        return transtornoMental;
    }

    /**
     *
     * @param transtornoMental
     * The transtorno_mental
     */
    public void setTranstornoMental(String transtornoMental) {
        this.transtornoMental = transtornoMental;
    }

    /**
     *
     * @return
     * The tipoFisico
     */
    public String getTipoFisico() {
        return tipoFisico;
    }

    /**
     *
     * @param tipoFisico
     * The tipo_fisico
     */
    public void setTipoFisico(String tipoFisico) {
        this.tipoFisico = tipoFisico;
    }

    /**
     *
     * @return
     * The pele
     */
    public String getPele() {
        return pele;
    }

    /**
     *
     * @param pele
     * The pele
     */
    public void setPele(String pele) {
        this.pele = pele;
    }

    /**
     *
     * @return
     * The peso
     */
    public String getPeso() {
        return peso;
    }

    /**
     *
     * @param peso
     * The peso
     */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    /**
     *
     * @return
     * The altura
     */
    public String getAltura() {
        return altura;
    }

    /**
     *
     * @param altura
     * The altura
     */
    public void setAltura(String altura) {
        this.altura = altura;
    }

    /**
     *
     * @return
     * The olhos
     */
    public String getOlhos() {
        return olhos;
    }

    /**
     *
     * @param olhos
     * The olhos
     */
    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    /**
     *
     * @return
     * The cabelos
     */
    public String getCabelos() {
        return cabelos;
    }

    /**
     *
     * @param cabelos
     * The cabelos
     */
    public void setCabelos(String cabelos) {
        this.cabelos = cabelos;
    }

    /**
     *
     * @return
     * The dataRegistro
     */
    public String getDataRegistro() {
        return dataRegistro;
    }

    /**
     *
     * @param dataRegistro
     * The data_registro
     */
    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    /**
     *
     * @return
     * The dataAtualizacao
     */
    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    /**
     *
     * @param dataAtualizacao
     * The data_atualizacao
     */
    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    /**
     *
     * @return
     * The updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     *
     * @param updatedAt
     * The updated_at
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public Object getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     *
     * @param situacao
     * The situacao
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}