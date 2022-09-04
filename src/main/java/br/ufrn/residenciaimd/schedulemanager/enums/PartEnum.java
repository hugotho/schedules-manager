package br.ufrn.residenciaimd.schedulemanager.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PartEnum {

    AGGRAVATING("Agravante"),
    AGGRAVATED("Agravado");

    private final String type;

    private PartEnum(String type){
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }
}
