package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.ApplicationContext;
import ua.nure.melnyk.SummaryTask4.service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

/**
 * Holder for all commands.<br/>
 */
public class CommandContainer {
    private static final Logger LOG = Logger.getLogger(CommandContainer.class);

    /**
     * Returns command object with the given name.
     *
     * @param commandName Name of the command.
     * @return Command object.
     */
    public static Command get(String commandName, ServletContext servletContext) {
        Map<String, Command> commands = (Map<String, Command>) servletContext.getAttribute("commands");
        if (commandName == null || !commands.containsKey(commandName)) {
            LOG.trace("Command not found, name --> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }

}
