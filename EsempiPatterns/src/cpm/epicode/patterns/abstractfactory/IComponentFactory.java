package cpm.epicode.patterns.abstractfactory;

public interface IComponentFactory {
	Component create(String type) throws Exception;
}
