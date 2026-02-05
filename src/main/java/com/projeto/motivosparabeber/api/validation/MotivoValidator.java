package com.projeto.motivosparabeber.api.validation;

import com.projeto.motivosparabeber.api.exception.DescriptionTooLongException;
import com.projeto.motivosparabeber.api.exception.ValidationException;
import com.projeto.motivosparabeber.api.model.Motivo;

import java.time.Year;

public class MotivoValidator {


    public static void validarNovoMotivo(Motivo motivo) {

        if (motivo.getAno() != null && motivo.getAno() > Year.now().getValue()) {
            throw new ValidationException("Ano não pode ser no futuro.");
        }

        if (motivo.getDescricao().length() > 275) {
            throw new DescriptionTooLongException("Descrição precisa ter menos que 275 caracteres.");
        }

    }


}
