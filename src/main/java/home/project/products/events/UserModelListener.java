package home.project.products.events;

import home.project.products.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class UserModelListener extends AbstractMongoEventListener<User> {

    private Logger logger = LoggerFactory.getLogger(ProductModelListener.class.getName());

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UserModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {

        logger.warn("onBeforeConvert" + event);

        if ((event.getSource().getId() == null) || event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(User.class.getName()));
        }
    }
}