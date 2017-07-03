package com.dogvacay.parse

/**
* Class add help arguments to your tool
* Extended from CliBuilder
*/
class Arguments extends CliBuilder {
	
	/**
	 * Adds all the help options needed to display options
	 * Usage :
	 * def cli = new Arguments()
     * cli.with {
     *     f longOpt: 'file', args: 1, argName: 'file', required: true, 'List of users to send to the message to'
     *     m longOpt: 'message', args: 1, argName: 'message', required : true, 'Notification message to send'
     *     v longOpt: 'visitor', argName: 'visitor', required: false, 'Ids in the file are vsitor ids, default: userIds'
     * }
     * def options = cli.parse(args)
     * if (cli.help(options)) {
     *     return null
     * }
	 */
	Arguments() {
		//print this.usage
		if (this.usage == "groovy") {
			this.usage = "Script usage"
		}
		this.header = "\nOptions:"
		this.stopAtNonOption = false
		this.footer = "+\n\n"
		this.with{
			h longOpt: 'help', 'Show help information'
		}
	}

	/**
	 * Display help usage if user asks.
	 *
	 * @param Cli option
	 * @return Return true
	 */
	public boolean help(options) {

		// fields not accepted, or not in list
		if (options == null) return true

		if (!options) {
			usage()
			return true
		}

		if (options.h) {
			usage()
			return true
		}
		return false
	}
}
