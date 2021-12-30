package kitchenpos.table.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import kitchenpos.table.application.TableService;

@Component
public class TableEventHandler {
	private final TableService tableService;

	public TableEventHandler(TableService tableService) {
		this.tableService = tableService;
	}

	@EventListener
	public void grouped(TableEvent.Grouped event) {
		tableService.grouped(event.getTableGroup(), event.getOrderTables());
	}

	@EventListener
	public void ungrouped(TableEvent.Ungrouped event) {
		tableService.ungrouped(event.getTableGroupId());
	}

}