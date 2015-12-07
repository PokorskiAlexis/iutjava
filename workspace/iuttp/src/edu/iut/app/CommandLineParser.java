package edu.iut.app;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;

// TODO: Auto-generated Javadoc
/**
 * La Classe CommandLineParser.
 */
public class CommandLineParser {
	
	/** Les options. */
	protected HashMap<String, CommandLineOption<?>> options;
	
	/** Tableau d'erreur lors du traitement des arguments */
	protected ArrayList<String> parseErrors;
		
	/**
	 * Crée une nouvelle CommandLineParser.
	 */
	public CommandLineParser() {
		options = new HashMap<String, CommandLineOption<?> >();
		parseErrors = new ArrayList<String>();
	}
	
	/**
	 * Ajouter des options.
	 *
	 * @param option à rajouter
	 */
	public void addOption(CommandLineOption<?> option) {
		if (option != null) {
			options.put(option.getKey(),option);
		}
	}
	
	/**
	 * Traite les arguments
	 *
	 * @param args l'argument
	 */
	public void parse(String[] args) {
		for (String argument: args) {
			String[] keyValue=argument.split("=");
			if (options.containsKey(keyValue[0])) {
				switch (((CommandLineOption<?>)options.get(keyValue[0])).getOptionType()) {
					case FILE:
						CommandLineOption<File> fileOption = (CommandLineOption<File>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							fileOption.setValue(new File(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					/* EX1 : reproduire le comportement de 'case FILE', pour STRING,INTEGER, ... */
					case INTEGER:
						CommandLineOption<Integer> IntegerOption = (CommandLineOption<Integer>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							IntegerOption.setValue(new Integer(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					case STRING:
						CommandLineOption<String> StringOption = (CommandLineOption<String>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							StringOption.setValue(new String(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					case DOUBLE:
						CommandLineOption<Double> DoubleOption = (CommandLineOption<Double>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							DoubleOption.setValue(new Double(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					case NOVALUE:
						CommandLineOption<Boolean> NoValueOption = (CommandLineOption<Boolean>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							NoValueOption.setValue(true);
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					default:
						parseErrors.add("Unrecognize option type.");						
				}
			}
		}
	}
	
	/**
	 * Obtenir l'option en fonction d'une chaine de caractère.
	 *
	 * @param key la chaine
	 * @return l'option
	 */
	public CommandLineOption<?> getOption(String key) {
		if (options.containsKey(key)) {
			return options.get(key);
		}
		return null;
	}
	
	/**
	 * Obtenir les erreurs
	 *
	 * @return les erreurs
	 */
	public ArrayList<String> getErrors() {
		return parseErrors;
	}
	
}
