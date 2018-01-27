package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ViewSettingsCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ViewSettingsCommand.class);
    private static final long serialVersionUID = -8017310209581272826L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        LOG.debug("Command finished");
        return Path.PAGE_SETTINGS;

    }
}
