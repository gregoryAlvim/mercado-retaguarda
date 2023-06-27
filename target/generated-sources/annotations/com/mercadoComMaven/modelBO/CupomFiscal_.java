package com.mercadoComMaven.modelBO;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-26T20:18:22")
@StaticMetamodel(CupomFiscal.class)
public class CupomFiscal_ { 

    public static volatile SingularAttribute<CupomFiscal, String> horaVenda;
    public static volatile SingularAttribute<CupomFiscal, Float> totalCupom;
    public static volatile SingularAttribute<CupomFiscal, Date> dataVenda;
    public static volatile SingularAttribute<CupomFiscal, Float> valorDesconto;
    public static volatile SingularAttribute<CupomFiscal, Float> valorAcrescimo;
    public static volatile SingularAttribute<CupomFiscal, UUID> id;
    public static volatile SingularAttribute<CupomFiscal, Character> status;

}