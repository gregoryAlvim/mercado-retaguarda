package com.mercadoComMaven.modelBO;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-26T20:18:22")
@StaticMetamodel(Cliente.class)
public class Cliente_ extends Pessoa_ {

    public static volatile SingularAttribute<Cliente, String> rg;
    public static volatile SingularAttribute<Cliente, String> cpf;
    public static volatile SingularAttribute<Cliente, Date> dtNascimento;
    public static volatile SingularAttribute<Cliente, Character> sexo;

}