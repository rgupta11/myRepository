# Datadog Integration Setup

This guide helps you set up Datadog monitoring and log collection for your Book Search application.

## Prerequisites

1. **Datadog Account**: Sign up at [https://www.datadoghq.com/](https://www.datadoghq.com/)
2. **API Key**: Get your API key from [Datadog Organization Settings](https://app.datadoghq.com/organization-settings/api-keys)

## Setup Instructions

### 1. Configure Environment Variables

1. Copy the example environment file:
   ```bash
   cp .env.example .env
   ```

2. Edit the `.env` file and replace the placeholder values:
   ```bash
   # Replace with your actual Datadog API key
   DD_API_KEY=your-actual-datadog-api-key-here
   
   # Set your Datadog site (US: datadoghq.com, EU: datadoghq.eu)
   DD_SITE=datadoghq.com
   
   # Set environment name
   DD_ENV=development
   ```

### 2. Start Services with Datadog Agent

Run the complete stack including Datadog agent:

```bash
docker-compose up -d
```

This will start:
- **PostgreSQL Database** (library-db)
- **pgAdmin** (database management)
- **Datadog Agent** (monitoring and log collection)

### 3. Verify Datadog Integration

1. **Check Agent Status**:
   ```bash
   docker-compose exec datadog-agent agent status
   ```

2. **View Logs**:
   ```bash
   docker-compose logs datadog-agent
   ```

3. **Check Datadog Dashboard**:
   - Go to [Datadog Logs](https://app.datadoghq.com/logs/livetail)
   - Look for logs from service: `book-search`

### 4. Application Integration

The application is already configured to send structured logs to Datadog via:

- **JSON Log Format**: All logs are in JSON format for better parsing
- **Trace Correlation**: Logs include trace IDs for APM correlation
- **Service Tags**: Logs are tagged with service, environment, and version
- **Auto-Discovery**: Datadog agent automatically discovers and monitors containers

### 5. Running Your Spring Boot Application with Datadog

When running your Spring Boot application (either in Docker or locally), you can enable Datadog APM tracing by adding the Java agent:

#### Option A: Docker (Recommended)
Add this to your Spring Boot Dockerfile:
```dockerfile
# Download Datadog Java agent
RUN wget -O dd-java-agent.jar https://dtdg.co/latest-java-tracer

# Run with Datadog agent
CMD ["java", "-javaagent:dd-java-agent.jar", "-jar", "book-search.jar"]
```

#### Option B: Local Development
```bash
# Download the agent
wget -O dd-java-agent.jar https://dtdg.co/latest-java-tracer

# Run your application
java -javaagent:dd-java-agent.jar \
     -Ddd.service=book-search \
     -Ddd.env=development \
     -Ddd.version=1.0.0 \
     -jar target/book-search-1.0-SNAPSHOT.jar
```

## Features Enabled

### 📊 **Application Performance Monitoring (APM)**
- Request tracing
- Database query monitoring
- Performance metrics

### 📝 **Log Management**
- Centralized log collection
- JSON structured logging
- Log-trace correlation
- Real-time log streaming

### 🔧 **Infrastructure Monitoring**
- Container metrics
- Database performance
- System resource usage

### 🚨 **Alerting**
- Set up alerts on errors
- Performance threshold monitoring
- Log pattern detection

## Datadog Dashboard Features

Once logs are flowing, you can:

1. **Create Custom Dashboards** with application metrics
2. **Set up Alerts** for error rates or performance issues
3. **Use Log Analytics** to search and analyze application behavior
4. **Monitor Database Performance** with PostgreSQL integration
5. **Track API Endpoints** with automatic service mapping

## Troubleshooting

### No Logs Appearing in Datadog

1. **Check API Key**:
   ```bash
   docker-compose exec datadog-agent agent status | grep "API Keys status"
   ```

2. **Verify Agent Connection**:
   ```bash
   docker-compose exec datadog-agent agent status | grep "Connectivity"
   ```

3. **Check Log Configuration**:
   ```bash
   docker-compose exec datadog-agent agent status | grep -A 20 "Logs Agent"
   ```

### Container Issues

1. **Restart Datadog Agent**:
   ```bash
   docker-compose restart datadog-agent
   ```

2. **Check Container Logs**:
   ```bash
   docker-compose logs datadog-agent
   ```

## Security Notes

- **Never commit your `.env` file** with real API keys
- **Use different API keys** for different environments
- **Restrict API key permissions** in Datadog organization settings
- **Monitor API key usage** in Datadog organization settings

## Additional Resources

- [Datadog Docker Integration](https://docs.datadoghq.com/agent/docker/)
- [Datadog Java APM](https://docs.datadoghq.com/tracing/setup_overview/setup/java/)
- [Datadog Log Management](https://docs.datadoghq.com/logs/)
- [Spring Boot + Datadog](https://docs.datadoghq.com/tracing/setup_overview/setup/java/?tab=springboot)
