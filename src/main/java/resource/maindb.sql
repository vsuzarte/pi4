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
        disponivel BOOLEAN
       
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
        telefoneCliente VARCHAR(14) NOT NULL,
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


INSERT INTO CLIENTE(nomeCliente,emailCliente,senhaCliente,cepCliente,estadoCliente,ruaCliente,numCasa,complemento,bairro,nomeContato,telefoneCliente,disponivel) VALUES ('biel', 'biel@biel','123','0677105','bra','bra',12,'123','haha','ha','454545',TRUE);
 


