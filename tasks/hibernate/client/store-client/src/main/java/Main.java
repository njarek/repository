import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
    private static String id="basket id";
 
    public static void main(String... args) throws Exception {
 
        final Options options = createOptions();
        final CommandLine line = getCommandLine(options, args);
 
        if (line.hasOption("help")) {
            help(options);
            return;
        } else if (line.hasOption("update")){
        	System.out.println("updateing "+Integer.valueOf(line.getOptionValue("update")));
        }  else if (line.hasOption("find")){
        	System.out.println("looking for "+Integer.valueOf(line.getOptionValue("find")));
        }  
    }
 
 
    private static CommandLine getCommandLine(final Options options, final String[] args)
        throws Exception {
        final CommandLineParser parser = new GnuParser();
        final CommandLine line;
 
        try {
            line = parser.parse(options, args);
        } catch (ParseException e) {
            help(options);
            throw new Exception("Unable to process command line options");
        }
 
        return line;
    }
 
    @SuppressWarnings("static-access")
    private static Options createOptions() {
        final Options options = new Options();
        options.addOption("help", false, "USAGE: basket [-" + id + " int]");
        options.addOption(OptionBuilder
                .withType(Integer.class)
                .withArgName("int")
                .hasArg()
                .withDescription( " - updates "+id )
                .create("update"));
        options.addOption(OptionBuilder
                .withType(Integer.class)
                .withArgName("int")
                .hasArg()
                .withDescription(" - looks for "+id)
                .create("find"));
 
        return options;
    }
 
    private static void help(final Options options) {
        final HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("FeeLifecycleTask", options);
    }
}