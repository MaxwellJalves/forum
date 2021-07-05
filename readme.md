#Informações Uteis

# Dependencias:

- Atualizado as dependencias do Springfox para a versão 2.10.5 para evitar Vulnerabilidades diretas informada no site : 
-   [links](https://snyk.io/vuln/maven:io.springfox%3Aspringfox-swagger-ui?utm_medium=Partner&utm_source=RedHat&utm_campaign=Code-Ready-Analytics-2020&utm_content=vuln/maven:io.springfox%3Aspringfox-swagger-ui) snyk.io 


		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger2</artifactId>
			<version>2.9.2</version>
		</dependency>
		
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-swagger-ui</artifactId>
			<version>2.10.5</version>
		</dependency>


### Utilizando a URI  
-	uri/swagger-ui.html  permite acessar a interface do usuario e realizar os testes dos endpoints.
-	<b>Referencias sobre URI:</b> https://docs.actian.com/dataconnect/11.6/index.html#page/User/URI_Connections.htm

# Adicionando Profile

-	Para podermos estruturar o projeto no ambiente de Desenvolvimento, Testes/QA e Produção , criamos profiles

- [links](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.profiles)
-	org.springframework.context.annotation.Profile
@Profile("Dev")




# Segurança 

-[links](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.security)

# Testes
--Anotações abaixo serão organizadas em um segundo momento.

#todo conteúdo é uma revisão basica do Spring e conteudos 

--DSpring.profiles.active=dev

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTEstDatabase.Replace.NONE)
--Precisamos utilizar essa anotação para que o Spring não considere que os testes devem sempre ser executados utilizando um banco de dados em memória.

https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/jdbc/AutoConfigureTestDatabase.html


--Repository
@ActiveProfiles("test")  
Anotacao força a inicialização no ambiente de teste. para localizar o profile de teste
srping.datasource.initialization-mode=never   --nunca inicializa o banco sempre será vazio

--Test
TestEntityManager manager;

--criar uma instancia do dado que será testado.
--popular valores esperados
valissar com os Assert.

OBS::
	Um Profile pode carregar um ou mais parametros;
		Ex: @Profile(value={"prod","test"})
---Testando o controller
@WebMvcTest -não encontra  o services
@SpringBootTeste --Permite Carregar todas as classes
@AutoConfigurMock
@ActiveProfiles("teste")
-------------------------------------------------------------


@Autowired
private MockMvc mock;

void teste(){
URI uri = new URI("/rota");
String json = "{\"email\":\"invalid\"}";

//Api do mock MVC
mockMvc.perform(MockMvcRequesBuilders
       .post(uri)
       .content(json)
       .contentType(MediaType.APPLICATION_JSON))
	.andExpect(MockMvcResultMatchers.status().id(400));


}
- A anotação @SpringBootTest serve para que o Spring inicialize o servidor e carregue os beans da aplicação durante a execução dos testes automatizados.