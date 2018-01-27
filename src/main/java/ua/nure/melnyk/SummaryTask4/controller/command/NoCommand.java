package ua.nure.melnyk.SummaryTask4.controller.command;

import org.apache.log4j.Logger;
import ua.nure.melnyk.SummaryTask4.Const.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class NoCommand extends Command {

    private static final Logger LOG = Logger.getLogger(NoCommand.class);
    private static final long serialVersionUID = -847938813673027428L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOG.debug("Command starts");

        String errorMessage = "No such command";
        request.setAttribute("errorMessage", errorMessage);
        LOG.error("Set the request attribute: errorMessage --> " + errorMessage);

        LOG.debug("Command finished");
        return Path.PAGE_ERROR_PAGE;
    }
}
