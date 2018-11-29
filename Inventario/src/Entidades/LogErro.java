package Entidades;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LogErro implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String codigoMaquina;
	private String category;
	private String categoryString;
	private String computerName;
	private String data;
	private String eventCode;
	private String eventIdentifier;
	private String insertionStrings;
	private String logFile;
	private String message;
	private String recordNumber;
	private String sourceName;
	private String timeGenerated;
	private String timeWritten;
	private String type;
	private String user;
	private String comando;
	
	
	public String getCodigoMaquina() {
		return codigoMaquina;
	}
	public void setCodigoMaquina(String codigoMaquina) {
		this.codigoMaquina = codigoMaquina;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryString() {
		return categoryString;
	}
	public void setCategoryString(String categoryString) {
		this.categoryString = categoryString;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEventCode() {
		return eventCode;
	}
	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}
	public String getEventIdentifier() {
		return eventIdentifier;
	}
	public void setEventIdentifier(String eventIdentifier) {
		this.eventIdentifier = eventIdentifier;
	}
	public String getInsertionStrings() {
		return insertionStrings;
	}
	public void setInsertionStrings(String insertionStrings) {
		this.insertionStrings = insertionStrings;
	}
	public String getLogFile() {
		return logFile;
	}
	public void setLogFile(String logFile) {
		this.logFile = logFile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRecordNumber() {
		return recordNumber;
	}
	public void setRecordNumber(String recordNumber) {
		this.recordNumber = recordNumber;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getTimeGenerated() {
		return timeGenerated;
	}
	public void setTimeGenerated(String timeGenerated) {
		this.timeGenerated = timeGenerated;
	}
	public String getTimeWritten() {
		return timeWritten;
	}
	public void setTimeWritten(String timeWritten) {
		this.timeWritten = timeWritten;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	
}
