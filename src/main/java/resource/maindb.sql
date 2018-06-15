/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  guilherme.rpinto
 * Created: 03/10/2017
 */

    CREATE TABLE Produto(
        idProduto INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        nomeProduto VARCHAR(50) NOT NULL,
        descricao VARCHAR(255),
        valorProduto DOUBLE NOT NULL,
        c1 VARCHAR(255),
        c2 VARCHAR(255),
        c3 VARCHAR(255),
        c4 VARCHAR(255),
        c5 VARCHAR(255),
        c6 VARCHAR(255),
        categoria VARCHAR(255),
        img VARCHAR(255),
        imgV1 VARCHAR(255),
        imgV2 VARCHAR(255),
        imgV3 VARCHAR(255),
        imgC1 VARCHAR(255),
        imgC2 VARCHAR(255),
        imgC3 VARCHAR(255),
        disponivel BOOLEAN
       
);

CREATE TABLE Mensagens(
idMensagem INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
idCliente INTEGER NOT NULL,
mensagem VARCHAR(255) NOT NULL,
assunto VARCHAR(255) NOT NULL,
resposta VARCHAR(255),
status VARCHAR(255),
FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

    CREATE TABLE Cliente (
        idCliente INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        nomeCliente VARCHAR(50) NOT NULL,
        emailCliente VARCHAR(50) NOT NULL,
        senhaCliente VARCHAR(50) NOT NULL,
        cepCliente VARCHAR(50),
        estadoCliente VARCHAR(50),
        cidadeCliente VARCHAR(50),
        ruaCliente VARCHAR(50),
        numCasa VARCHAR(50),
        complemento VARCHAR(50),
        bairro VARCHAR(50),
        nomeContato VARCHAR(50),
        telefoneCliente VARCHAR(14),
        disponivel BOOLEAN
);

    CREATE TABLE Usuario (
        idUsuario INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        nomeUsuario VARCHAR(50) NOT NULL,
        funcao VARCHAR(50) NOT NULL,
        userName VARCHAR(20)NOT NULL,
        senha VARCHAR(20) NOT NULL,
        disponivel BOOLEAN
        
);

    CREATE TABLE Venda (
        idVenda INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        idCliente INT NOT NULL,
        valorTotal DOUBLE NOT NULL,
        cartao VARCHAR(255),
        status VARCHAR(255),
        FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
      
);

    CREATE TABLE ItemVenda(
        idItemVenda INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
        idVenda INTEGER NOT NULL,
        idProduto INTEGER NOT NULL,
        Quantidade INT NOT NULL,
        FOREIGN KEY (idVenda) REFERENCES Venda(idVenda),
        FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
);



INSERT INTO USUARIO(NOMEUSUARIO,FUNCAO,USERNAME,SENHA,DISPONIVEL) VALUES ('ADMIN','gerente','ADMIN','ADMIN',TRUE);


INSERT INTO CLIENTE(nomeCliente,emailCliente,senhaCliente,cepCliente,estadoCliente,ruaCliente,numCasa,complemento,bairro,nomeContato,telefoneCliente,disponivel) VALUES ('Gabriel', 'gabriel@hotmail.com','123','05831120','SP','Rua akidaban','666','K','haha','ha','454545',TRUE);
 
/* Mouses */

INSERT INTO PRODUTO(NOMEPRODUTO,DESCRICAO,VALORPRODUTO,C1,C2,C3,C4,C5,C6,CATEGORIA,IMG,IMGV1,IMGV2,IMGV3,IMGC1,IMGC2,IMGC3,DISPONIVEL) VALUES ('Manba','O Razer Mamba oferece movimento completamente irrestrito sem comprometer o controle ou a precisÃ£o. Com ou sem fio, o Razer Mamba oferece uma taxa de resposta de 1 ms *',300,'Melhor mouse do mercado','Sensor laser de 16.000 DPI 5G','Tecnologia de força de clique ajustável','Tecnologia de cabeamento duplo com tecnologia de jogos / sem fio', 'Design ergonômico para destro com garras laterais de borracha texturizada', 'IluminaÃ§Ã£o cromÃ¡tica com verdadeiras 16,8 milhÃµes de opÃ§Ãµes de cores personalizÃ¡veis', 'Mouse','img/manba/img.png','img/manba/imgV1.png','img/manba/imgV2.png','img/manba/imgV3.png','img/manba/imgC1.jpg','img/manba/imgC2.jpg','img/manba/imgC1.jpg',TRUE );

INSERT INTO PRODUTO(NOMEPRODUTO,DESCRICAO,VALORPRODUTO,C1,C2,C3,C4,C5,C6,CATEGORIA,IMG,IMGV1,IMGV2,IMGV3,IMGC1,IMGC2,IMGC3,DISPONIVEL) VALUES ('Naga','O Razer Naga Criado especificamente para jogadores de MOBA, o Razer Naga Hex V2 vem com um botão giratório de 7 botões, posicionado de forma a garantir que você nunca clicou erroneamente.',900,'Roda de polegar mecânica de 7 botões','Total de 14 botões programáveis ​​otimizados para MOBA','Aderência de polegar emborrachado','Verdadeiro sensor laser de 16.000 DPI 5G', 'A roda de polegar foi projetada para posicionar botões eqüidistantes do polegar', 'IluminaÃ§Ã£o cromÃ¡tica com verdadeiras 16,8 milhÃµes de opÃ§Ãµes de cores personalizÃ¡veis', 'Mouse','img/naga/img.png','img/naga/imgV1.png','img/naga/imgV2.png','img/naga/imgV3.png','img/naga/imgC1.jpg','img/naga/imgC2.jpg','img/naga/imgC1.jpg',TRUE );

INSERT INTO PRODUTO(NOMEPRODUTO,DESCRICAO,VALORPRODUTO,C1,C2,C3,C4,C5,C6,CATEGORIA,IMG,IMGV1,IMGV2,IMGV3,IMGC1,IMGC2,IMGC3,DISPONIVEL) VALUES ('Ouroboros','De um descanso de palma arqueado ajustável a uma parte traseira retrátil, bem como quatro painéis laterais intercambiáveis, o Razer Ouroboros é totalmente personalizável para suas necessidades pessoais.',1400,'Coberto pela garantia de um ano da Razer','Totalmente recondicionado pelos técnicos da Razer para atender às especificações de desempenho dos novos produtos Razer','Reembalados e vedados para atender aos rigorosos requisitos de inspeção final da Razer','Pode conter pequenas imperfeições cosméticas', 'Em oferta limitada', 'O Razer Ouroboros está equipado com o sensor mais avançado e configurável de todos os tempos, o novo sensor laser 4G de 8200 ppp.', 'Mouse','img/ouro/img.png','img/ouro/imgV1.png','img/ouro/imgV2.png','img/ouro/imgV3.png','img/ouro/imgC1.jpg','img/ouro/imgC2.jpg','img/ouro/imgC1.jpg',TRUE );

/* Telcados */

INSERT INTO PRODUTO(NOMEPRODUTO,DESCRICAO,VALORPRODUTO,C1,C2,C3,C4,C5,C6,CATEGORIA,IMG,IMGV1,IMGV2,IMGV3,IMGC1,IMGC2,IMGC3,DISPONIVEL) VALUES ('Orbweaver','O Razer Orbweaver Chroma possui teclas retroiluminadas individualmente programáveis ​​com 16,8 milhões de opções de cores, todas facilmente configuradas através do Razer Synapse.',459,'Chaves mecânicas Razer ™ com força de acionamento de 50 g','30 teclas totalmente programáveis','Comprimentos macro ilimitados','Mão ajustável, polegar e descanso para o máximo conforto','Retroiluminação Chroma com 16,8 milhões de opções de cores personalizáveis', 'Desde os efeitos de iluminação pré-carregados para diferentes tipos de jogos, até a sua própria paleta de cores personalizada e exclusiva', 'Teclado','img/obw/img.png','img/obw/imgV1.png','img/obw/imgV2.png','img/obw/imgV3.png','img/obw/imgC1.jpg','img/obw/imgC2.jpg','img/obw/imgC1.jpg',TRUE );

INSERT INTO PRODUTO(NOMEPRODUTO,DESCRICAO,VALORPRODUTO,C1,C2,C3,C4,C5,C6,CATEGORIA,IMG,IMGV1,IMGV2,IMGV3,IMGC1,IMGC2,IMGC3,DISPONIVEL) VALUES ('DeathStalker ','O Razer DeathStalker  Chroma possui teclas retroiluminadas individualmente programáveis ​​com 16,8 milhões de opções de cores, todas facilmente configuradas através do Razer Synapse.',414,'Chaves mecânicas Razer ™ com força de acionamento de 50 g','30 teclas totalmente programáveis','Comprimentos macro ilimitados','Mão ajustável, polegar e descanso para o máximo conforto','Retroiluminação Chroma com 16,8 milhões de opções de cores personalizáveis', 'Desde os efeitos de iluminação pré-carregados para diferentes tipos de jogos, até a sua própria paleta de cores personalizada e exclusiva', 'Teclado','img/tdd/img.png','img/tdd/imgV1.png','img/tdd/imgV2.png','img/tdd/imgV3.png','img/tdd/imgC1.jpg','img/tdd/imgC2.jpg','img/tdd/imgC1.jpg',TRUE );

INSERT INTO PRODUTO(NOMEPRODUTO,DESCRICAO,VALORPRODUTO,C1,C2,C3,C4,C5,C6,CATEGORIA,IMG,IMGV1,IMGV2,IMGV3,IMGC1,IMGC2,IMGC3,DISPONIVEL) VALUES ('Ornata ','O Razer Ornata Chroma possui teclas retroiluminadas individualmente programáveis ​​com 16,8 milhões de opções de cores, todas facilmente configuradas através do Razer Synapse.',449,'Chaves mecânicas Razer ™ com força de acionamento de 50 g','30 teclas totalmente programáveis','Comprimentos macro ilimitados','Mão ajustável, polegar e descanso para o máximo conforto','Retroiluminação Chroma com 16,8 milhões de opções de cores personalizáveis', 'Desde os efeitos de iluminação pré-carregados para diferentes tipos de jogos, até a sua própria paleta de cores personalizada e exclusiva', 'Teclado','img/orn/img.png','img/orn/imgV1.png','img/orn/imgV2.png','img/orn/imgV3.png','img/orn/imgC1.jpg','img/orn/imgC2.jpg','img/orn/imgC1.jpg',TRUE );

/*Mouse Pad*/


INSERT INTO PRODUTO(NOMEPRODUTO,DESCRICAO,VALORPRODUTO,C1,C2,C3,C4,C5,C6,CATEGORIA,IMG,IMGV1,IMGV2,IMGV3,IMGC1,IMGC2,IMGC3,DISPONIVEL) VALUES ('Firefly ','Razer Firefly Cloth Edition apresenta uma superfície de pano que lhe dá precisão e conforto.',450,'Superfície de pano para jogabilidade equilibrada','Tecido texturizado, otimizado para rastreamento altamente responsivo','Iluminação personalizável Razer Chroma','Base de borracha antiderrapante','Razer Synapse ativado (para iluminação personalizável do Razer Chroma)', 'Sincronização com seus outros dispositivos habilitados para o Razer Chroma significa que sua experiência de jogo', 'Mousepad','img/fire/img.png','img/fire/imgV1.png','img/fire/imgV2.png','img/fire/imgV3.png','img/fire/imgC1.jpg','img/fire/imgC2.jpg','img/fire/imgC1.jpg',TRUE );

/*Fones*/


INSERT INTO PRODUTO(NOMEPRODUTO,DESCRICAO,VALORPRODUTO,C1,C2,C3,C4,C5,C6,CATEGORIA,IMG,IMGV1,IMGV2,IMGV3,IMGC1,IMGC2,IMGC3,DISPONIVEL) VALUES ('ManOWar ','Mergulhe no jogo com total liberdade sem fio, com o headset de jogos para PC sem fio Razer',630,'Drivers: 50 mm, com ímãs de neodímio','Tipo de conexão: Transceptor USB sem fio','Alcance sem fio: 12 m / 40 pés','Freqüência sem fio: 2,4 Ghz','Duração da bateria: até 14 horas com iluminação Razer Chroma ', '20 horas sem iluminação Razer Chroma', 'Headset','img/man/img.png','img/man/imgV1.png','img/man/imgV2.png','img/man/imgV3.png','img/man/imgC1.jpg','img/man/imgC2.jpg','img/man/imgC1.jpg',TRUE );


insert into mensagens (idCliente, mensagem, assunto, resposta, status) values (1,'mensagem teste', 'teste', 'testado', 'respondido')