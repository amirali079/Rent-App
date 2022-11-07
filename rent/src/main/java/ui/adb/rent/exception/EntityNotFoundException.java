package ui.adb.rent.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String entityName, String id){
        super(entityName + " with id " + id + " not found");
    }
}

