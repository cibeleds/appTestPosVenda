package utils;

import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

public class DynamoDB {

    // Método para obter cliente DynamoDB com credenciais do AWS Toolkit para IntelliJ
    public DynamoDbClient getDynamoDbClient() {
        // Obter provedor de credenciais do AWS Toolkit para IntelliJ
        AwsCredentialsProvider credentialsProvider = ProfileCredentialsProvider.builder().profileName("sso").build();

        // Criar e retornar cliente DynamoDB configurado com a região
        return DynamoDbClient.builder()
                .region(Region.of("us-east-2"))
                .credentialsProvider(credentialsProvider)
                .build();
    }

    // Exemplo de operação DynamoDB (lista de tabelas)
    public void listTables() {
        DynamoDbClient dynamoDbClient = getDynamoDbClient();

        // Exemplo de operação DynamoDB (lista de tabelas)
        ListTablesResponse listTablesResponse = dynamoDbClient.listTables();
        System.out.println("raizen-power-customer-table-user-portal-hub-dev");
        listTablesResponse.tableNames().forEach(System.out::println);

        // Fechar o cliente DynamoDB quando não for mais necessário
        dynamoDbClient.close();
    }
}
