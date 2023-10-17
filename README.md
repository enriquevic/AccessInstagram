# Class LoginInstagram

Este é um exemplo simples de automação de login no Instagram usando o Selenium WebDriver em Java. O script realiza as seguintes ações:

1. Abre o navegador Chrome.
2. Acessa o site do Instagram.
3. Insere o nome de usuário e senha.
4. Clica no botão "Entrar".
5. Lida com pop-ups e mensagens de boas-vindas.

### Pré-requisitos
- [Java](https://www.java.com/pt-BR/download/) instalado
- [WebDriver para Chrome](https://sites.google.com/chromium.org/driver/) baixado e configurado no sistema.

### Como Usar
1. Clone este repositório.
2. Substitua "[Seu usuário do insta]" e "[Sua senha do insta]" no código pelo seu nome de usuário e senha do Instagram.
3. Certifique-se de que o WebDriver do Chrome está no caminho correto (`./src/main/chromedriver.exe`).
4. Execute o script Java.

```bash
java -cp .\path\to\selenium-server-standalone.jar;.\path\to\your\project\out\production\your_project_name br.com.roothub.miner.Miner
```

### Observações
- O script inclui pausas para aguardar a renderização de elementos na página. Recomenda-se ajustar esses tempos conforme necessário.
- Este exemplo assume a presença de elementos específicos no Instagram, que podem mudar com atualizações do site.

Lembre-se de ser responsável ao automatizar interações em sites, respeitando os termos de serviço de cada plataforma. Este exemplo é apenas educativo e pode necessitar de adaptações dependendo das mudanças futuras no Instagram.
