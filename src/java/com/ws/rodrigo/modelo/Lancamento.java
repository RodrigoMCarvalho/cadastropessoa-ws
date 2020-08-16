
package com.ws.rodrigo.modelo;

public class Lancamento {
    
    private Integer id;
    private String data;
    private String usuario;

    public Lancamento(Integer id, String data, String usuario) {
        this.id = id;
        this.data = data;
        this.usuario = usuario;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return  "id=" + id + ", data=" + data + ", usuario=" + usuario + '}';
    }
    
    
    
    
}
