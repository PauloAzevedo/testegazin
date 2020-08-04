package com.pauloazevedo.developers.dto;

import com.pauloazevedo.developers.models.Developer;
import com.pauloazevedo.developers.utils.Util;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulo
 */
public class DeveloperDto {
    private Integer id;    
    private String nome;
    private char sexo;
    private Integer idade;
    private String hobby;
    private String dataNascimento;

    public DeveloperDto(Developer dev) {
        this.id = dev.getId();
        this.nome = dev.getNome();
        this.sexo = dev.getSexo();
        this.idade = dev.getIdade();
        this.hobby = dev.getHobby();
        this.dataNascimento = Util.calendarToStringWeb(dev.getDataNascimento());
    }
    

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public char getSexo() {
        return sexo;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getHobby() {
        return hobby;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
    
    public static Page<DeveloperDto> converter(Page<Developer> devs){
        return devs.map(DeveloperDto::new);
    }
    
}
