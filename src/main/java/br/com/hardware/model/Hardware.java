package br.com.hardware.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hardware implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long idHardware;
    private String nome;
    private String fabricante;
    private Date dataHardware = new Date();   
    public String getDataHardware() {         
        
    SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");         
        return formato.format(dataHardware);
    }    
    
    public void setDataHardware(String dataHardware) {
    
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;         
        try {             
            data = formato.parse(dataHardware);         } 
        catch (ParseException ex) {             
            Logger.getLogger(Hardware.class.getName()).log(Level.SEVERE, null, ex);
        }         
        this.dataHardware = data;     }
    /**
     * @return the idHardware
     */
    public long getIdHardware() {
        return idHardware;
    }

    /**
     * @param idHardware the idProduto to set
     */
    public void setIdHardware(long idHardware) {
        this.idHardware = idHardware;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    
}
