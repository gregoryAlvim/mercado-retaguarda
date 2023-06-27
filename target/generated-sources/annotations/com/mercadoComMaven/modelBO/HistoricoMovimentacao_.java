package com.mercadoComMaven.modelBO;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-26T20:18:22")
@StaticMetamodel(HistoricoMovimentacao.class)
public class HistoricoMovimentacao_ { 

    public static volatile SingularAttribute<HistoricoMovimentacao, Character> tipo;
    public static volatile SingularAttribute<HistoricoMovimentacao, Date> data;
    public static volatile SingularAttribute<HistoricoMovimentacao, String> hora;
    public static volatile SingularAttribute<HistoricoMovimentacao, Float> qnt;
    public static volatile SingularAttribute<HistoricoMovimentacao, UUID> id;
    public static volatile SingularAttribute<HistoricoMovimentacao, Character> status;

}