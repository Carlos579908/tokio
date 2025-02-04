create table seguradoras(

                        id bigint not null auto_increment,
                        contaOrigem varchar(100) not null,
                        contaDestino varchar(100) not null unique,
                        valor varchar(100) not null,
                        taxa varchar(100) not null,


                        primary key(id)

);