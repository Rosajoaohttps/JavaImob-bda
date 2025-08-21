# poo_trabalho_jdbc

## Equipe

| Equipe     | Email                                  |
|------------|----------------------------------------|
| João Rosa  | Joaovitorrosamachado@hotmail.com       |
| Allan      | Empty                                  |

## Configurações

| Item          | Valor              |
|---------------|------------        |
| Banco de Dados| MySQL WorkBanch    |
| Schema        | ImobDataBase       |
| User          | Root               |  
| Password      | ********           |


## Diagrama de classe da UML

<img width="375" height="381" alt="UML-Imob" src="https://github.com/user-attachments/assets/1414b0cd-24dd-45c1-b698-8d2b46f299b6" />


## Diagrama MER

<img width="422" height="381" alt="MER-Imob" src="https://github.com/user-attachments/assets/091ddff6-d061-4551-b3f0-48ddf86f6b3e" />


## Instruções SQL

### Criação do schema e tabelas

```sql
// Conectar sem banco para criar o banco de dados, se necessário
            Connection conInicial = DriverManager.getConnection(urlSemBanco, user, password);
            Statement stInicial = conInicial.createStatement();
            stInicial.execute("CREATE DATABASE IF NOT EXISTS ImobDataBase;");
            stInicial.close();
            conInicial.close();
            System.out.println("Banco de dados criado ou já existente.");

            // Conectar no banco de dados
            Connection con = DriverManager.getConnection(urlComBanco, user, password);
            Statement st = con.createStatement();
            System.out.println("Conectado ao banco ImobDataBase!");

            // Criar tabela Imoveis
            String sql1 = "CREATE TABLE IF NOT EXISTS Imoveis (\n" +
                    "    id_imovel INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    endereco VARCHAR(255) NOT NULL,\n" +
                    "    tipo VARCHAR(50),\n" +
                    "    quartos INT,\n" +
                    "    valor_aluguel DECIMAL(10, 2),\n" +
                    "    status VARCHAR(50) NOT NULL\n" +
                    ");";

            // Criar tabela Clientes
            String sql2 = "CREATE TABLE IF NOT EXISTS Clientes (\n" +
                    "    id_cliente INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    nome VARCHAR(255) NOT NULL,\n" +
                    "    cpf VARCHAR(14) UNIQUE NOT NULL,\n" +
                    "    telefone VARCHAR(20),\n" +
                    "    email VARCHAR(255)\n" +
                    ");";

            // Criar tabela Contratos
            String sql3 = "CREATE TABLE IF NOT EXISTS Contratos (\n" +
                    "    id_contrato INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    valor DECIMAL(10, 2),\n" +
                    "    data_inicio DATE NOT NULL,\n" +
                    "    data_fim DATE NOT NULL,\n" +
                    "    id_imovel INT,\n" +
                    "    id_cliente INT,\n" +
                    "    FOREIGN KEY (id_imovel) REFERENCES Imoveis(id_imovel),\n" +
                    "    FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)\n" +
                    ");";
                      
///Inserção de registros.///



            // Inserir dados
            String sql4 = "INSERT INTO Imoveis (endereco, tipo, quartos, valor_aluguel, status) VALUES\n" +
                    "('Rua das Flores, 123', 'Apartamento', 2, 1500.00, 'Disponível'),\n" +
                    "('Avenida Principal, 456', 'Casa', 3, 2500.00, 'Alugado'),\n" +
                    "('Rua Bela Vista, 789', 'Apartamento', 1, 1200.00, 'Disponível'),\n" +
                    "('Rua do Sol, 1010', 'Casa', 4, 3200.00, 'Disponível'),\n" +
                    "('Travessa das Acácias, 222', 'Apartamento', 2, 1800.00, 'Alugado'),\n" +
                    "('Rua Palmeiras, 333', 'Cobertura', 3, 4000.00, 'Disponível'),\n" +
                    "('Rua das Laranjeiras, 444', 'Kitnet', 1, 900.00, 'Disponível'),\n" +
                    "('Rua dos Pinheiros, 555', 'Casa', 5, 3500.00, 'Alugado'),\n" +
                    "('Alameda das Rosas, 666', 'Apartamento', 2, 1600.00, 'Disponível'),\n" +
                    "('Rua São Jorge, 777', 'Casa', 3, 2700.00, 'Disponível');";
            // Inserir dados
            String sql5 = "INSERT INTO Clientes (nome, cpf, telefone, email) VALUES\n" +
                    "('Allan Big', '111.222.333-44', '99999-8888', 'allan.big@email.com'),\n" +
                    "('João Rosa', '555.666.777-88', '98888-7777', 'joao.rosa@email.com'),\n" +
                    "('Maria Clara', '123.456.789-00', '98765-4321', 'maria.clara@email.com'),\n" +
                    "('Carlos Silva', '234.567.890-11', '91234-5678', 'carlos.silva@email.com'),\n" +
                    "('Ana Beatriz', '345.678.901-22', '99876-5432', 'ana.beatriz@email.com'),\n" +
                    "('Pedro Henrique', '456.789.012-33', '98765-1234', 'pedro.henrique@email.com'),\n" +
                    "('Fernanda Lima', '567.890.123-44', '97654-3210', 'fernanda.lima@email.com'),\n" +
                    "('Lucas Martins', '678.901.234-55', '93456-7890', 'lucas.martins@email.com'),\n" +
                    "('Juliana Souza', '789.012.345-66', '94567-8901', 'juliana.souza@email.com'),\n" +
                    "('Rafael Almeida', '890.123.456-77', '95678-9012', 'rafael.almeida@email.com');";
            // Inserir dados
            String sql6 = "INSERT INTO Contratos (valor, data_inicio, data_fim, id_imovel, id_cliente) VALUES\n" +
                    "(1500.00, '2025-01-01', '2025-12-31', 1, 1),\n" +
                    "(2500.00, '2025-02-01', '2026-01-31', 2, 2),\n" +
                    "(1200.00, '2025-03-01', '2026-02-28', 3, 3),\n" +
                    "(3200.00, '2025-04-01', '2026-03-31', 4, 4),\n" +
                    "(1800.00, '2025-05-01', '2026-04-30', 5, 5),\n" +
                    "(4000.00, '2025-06-01', '2026-05-31', 6, 6),\n" +
                    "(900.00, '2025-07-01', '2026-06-30', 7, 7),\n" +
                    "(3500.00, '2025-08-01', '2026-07-31', 8, 8),\n" +
                    "(1600.00, '2025-09-01', '2026-08-31', 9, 9),\n" +
                    "(2700.00, '2025-10-01', '2026-09-30', 10, 10);";

            // Executar os comandos
            st.execute(sql1);
            st.execute(sql2);
            st.execute(sql3);
            st.execute(sql4);
            st.execute(sql5);
            st.execute(sql6);
