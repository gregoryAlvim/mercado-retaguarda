package com.mercadoComMaven.modelBO;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-26T20:18:22")
@StaticMetamodel(Pagamento.class)
public class Pagamento_ { 

    public static volatile SingularAttribute<Pagamento, Date> dataPagamento;
    public static volatile SingularAttribute<Pagamento, Float> valorDesconto;
    public static volatile SingularAttribute<Pagamento, Float> valorAcrescimo;
    public static volatile SingularAttribute<Pagamento, String> horaPagamento;
    public static volatile SingularAttribute<Pagamento, Float> valorPago;
    public static volatile SingularAttribute<Pagamento, Integer> id;
    public static volatile SingularAttribute<Pagamento, Character> status;

}