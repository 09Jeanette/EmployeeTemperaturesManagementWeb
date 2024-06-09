# Employee Temperatures Management Web

This repository contains a web application for managing employee temperatures. It includes functionalities for capturing and displaying temperature readings, with security roles for manager and supervisor.

## Technologies Used

- Java EE
- EJB (Enterprise JavaBeans)
- JPA (Java Persistence API)
- JPQL(Java Persistence Query Language)
- Java Web
- JSP
- Servlets
- HTML
- JavaScript
  
## Features

- **Manager:**
  - Capture the body temperature of employees.
- **Supervisor:**
  - Display details of employees with high temperature readings.
  - Display details of employees with acceptable temperature readings.
  - Display details of employees who registered high temperature readings more than once.
- Both roles can log out.

## Security

- **Manager:**
  - Username: `manager`
  - Password: `123`
- **Supervisor:**
  - Username: `supervisor`
  - Password: `123`


## How to Run

1. Clone the repository:
    ```sh
    git clone https://github.com/09Jeanette/EmployeeTemperaturesManagementWeb/tree/main
    ```
2. Open the project in your IDE (e.g., NetBeans).
3. Set up the security roles and deploy the application to your Java EE application server (e.g., GlassFish).
4. Access the application through your web browser.

## Setting Up JDBC Connection Pool in GlassFish via NetBeans

### Setting Up the Database in NetBeans

1. **Create the Database:**
    - Open NetBeans.
    - Go to the Services tab.
    - Expand the Databases node.
    - Right-click on Java DB and select Create Database.
    - Fill in the necessary details:
        - **Database Name**: `EmployeeDB`
        - **User Name**: `app`
        - **Password**: `app`
    - Click OK to create the database.

2. **Get the Database URL:**
    - Right-click on the newly created database under the Databases node.
    - Select Properties.
    - Copy the Database URL (e.g., `jdbc:derby://localhost:1527/EmployeeDB`).

### Start GlassFish Server

1. **Start GlassFish:**
    - Ensure your GlassFish server is added to NetBeans.
    - Right-click on the GlassFish server in the Servers node under the Services tab and select Start.

2. **Open GlassFish Admin Console via NetBeans:**
    - Once the server is started, right-click on the GlassFish server again.
    - Select View Admin Console. This will open a web browser and navigate to the GlassFish Admin Console (usually at `http://localhost:4848`).


### Configure JDBC Connection Pool in GlassFish

1. **Create JDBC Connection Pool:**
    - In the GlassFish Admin Console, navigate to **Resources** > **JDBC** > **JDBC Connection Pools**.
    - Click **New** to create a new pool:
        - **Pool Name**: `EmployeeDBPool`
        - **Resource Type**: `javax.sql.DataSource`
        - **Database Vendor**: `Derby`
    - Click **Next**.
    - Under **Additional Properties**, add the following:
        - `DatabaseName`: `EmployeeDB`
        - `User`: `app`
        - `Password`: `app`
        - `ServerName`: `localhost`
        - `PortNumber`: `1527`
        - **New Property**: `url` (Paste the copied database URL, e.g., `jdbc:derby://localhost:1527/EmployeeDB`)
    - Click **Finish**.

2. **Ping the Connection Pool:**
    - After configuring the connection pool, go to the General tab.
    - Click on Ping to test the connection.
    - Ensure the ping is successful.

## Add the EJB JAR File to the Web Application

1. **Include EJB JAR in Web Application:**
    - In NetBeans, right-click on the `EmployeeTemperaturesManagementWeb` project.
    - Select Properties.
    - Go to Libraries.
    - Click on Add JAR/Folder.
    - Navigate to and select the `TemperatureEJBModule` JAR file (usually located in the `dist` or `target` folder of the EJB module project).
    - Click Open to add the JAR file to the web application's classpath.
      
2. **Configure Security Roles in GlassFish:**
    -  Open the GlassFish Admin Console.
    - Navigate to **Configurations** > **server-config** > **Security** > **Realms**.
    - You can either create a new realm or use the existing file realm.
    - To use the existing file realm:
        - Click on `file` under the Realms list.
    - Manage users in the realm:
        - Click on **Manage Users**.
        - Click **New** to add a new user.
        - Add the following security roles:
        - **manager**
        - **supervisor**
        -  - Enter the Group List (e.g., `manager` or `supervisor`)

3. **Deploy the Application:**
    - Deploy the EJB Module:
        - Ensure the `TemperatureEJBModule` is running on your application server.
        - Right-click on the EJB module project and select Deploy.
    - Deploy the Web Application:
        - Right-click on the `EmployeeTemperaturesManagementWeb` project in NetBeans.
        - Select Run or Deploy.
        - Ensure the deployment is successful.

## License

This project is licensed under the MIT License.
