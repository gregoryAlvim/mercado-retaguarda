package com.mercadoComMaven.modelBO;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-26T20:18:22")
@StaticMetamodel(Pagar.class)
public class Pagar_ { 

    public static volatile SingularAttribute<Pagar, Date> dataVencimento;
    public static volatile SingularAttribute<Pagar, Integer> id;
    public static volatile SingularAttribute<Pagar, Float> valorPagar;
    public static volatile SingularAttribute<Pagar, Date> dataEmissao;
    public static volatile SingularAttribute<Pagar, String> horaEmissao;
    public static volatile SingularAttribute<Pagar, Character> status;

}