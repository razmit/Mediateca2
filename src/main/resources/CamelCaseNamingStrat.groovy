import org.hibernate.boot.model.naming.Identifier
import org.hibernate.boot.model.naming.PhysicalNamingStrategy
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment

public class CamelCaseNamingStrat implements PhysicalNamingStrategy {

    @Override
    public String propertyToColumnName(String propertyName) {
        return propertyName;
    }

    @Override
    public String tableName(String tableNamespace, String className) {

        return IdentifierMaooer.toIdentifier(className);
    }

    @Override
    Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null
    }

    @Override
    Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null
    }

    @Override
    Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null
    }

    @Override
    Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null
    }

    @Override
    Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null
    }
}
