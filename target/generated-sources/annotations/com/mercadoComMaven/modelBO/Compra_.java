package com.mercadoComMaven.modelBO;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-26T20:18:22")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Float> totalNF;
    public static volatile SingularAttribute<Compra, String> tipoNF;
    public static volatile SingularAttribute<Compra, Float> valorDesconto;
    public static volatile SingularAttribute<Compra, Float> valorAcrescimo;
    public static volatile SingularAttribute<Compra, String> hora;
    public static volatile SingularAttribute<Compra, Integer> id;
    public static volatile SingularAttribute<Compra, String> numeroNF;
    public static volatile SingularAttribute<Compra, Date> dataCompra;
    public static volatile SingularAttribute<Compra, Character> status;

}