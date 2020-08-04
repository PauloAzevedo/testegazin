package com.pauloazevedo.developers.form;

import com.pauloazevedo.developers.models.Developer;
import com.pauloazevedo.developers.repository.DeveloperRepository;
import com.pauloazevedo.developers.utils.Util;
import java.util.Calendar;
import java.util.Optional;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulo
 */
public class DeveloperForm {

    @NotNull
    private String nome;
    @NotNull
    private char sexo;
    @NotNull
    private String hobby;
    @NotNull
    private String dataNascimento;

    public Developer converter(DeveloperRepository developerRepository) {
        Calendar data = converterDataNascimento(dataNascimento);
        Integer idadeCalculada = Calendar.getInstance().getTime().getYear() - data.getTime().getYear();
        return new Developer(nome, sexo, idadeCalculada, hobby, data);
    }

    public Developer atualizar(Integer id, DeveloperRepository developerRepository) {
        Optional<Developer> devOpt = developerRepository.findById(id);
        if (devOpt.isPresent()) {
            Calendar data = converterDataNascimento(dataNascimento);
            Integer idadeCalculada = Calendar.getInstance().getTime().getYear() - data.getTime().getYear();
            Developer devEditado = devOpt.get();
            devEditado.setNome(nome);
            devEditado.setSexo(sexo);
            devEditado.setHobby(hobby);
            devEditado.setDataNascimento(data);
            devEditado.setIdade(idadeCalculada);
            return devEditado;
        }
        return null;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    private Calendar converterDataNascimento(String dataNascimento) {
        try {
            return Util.stringToCalendarWeb(dataNascimento);
        } catch (Exception ex) {
            return Calendar.getInstance();
        }
    }

}
