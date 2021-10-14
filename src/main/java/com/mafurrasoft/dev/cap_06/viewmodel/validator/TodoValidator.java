package com.mafurrasoft.dev.cap_06.viewmodel.validator;

import com.mafurrasoft.dev.entity.Todo;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.lang.Strings;
import org.zkoss.zk.ui.util.Clients;

public class TodoValidator extends AbstractValidator {
    @Override
    public void validate(ValidationContext ctx) {
        Todo todo = (Todo)ctx.getProperty().getValue();

        if(Strings.isBlank((todo.getSubject()))){
            Clients.showNotification("Assunto em branco.");

            ctx.setInvalid();
        }
    }
}
