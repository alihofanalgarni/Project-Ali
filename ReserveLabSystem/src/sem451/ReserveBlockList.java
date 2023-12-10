package sem451;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReserveBlockList {
    private List<ReserveBlock> reserveBlocks;

    public ReserveBlockList() {
        reserveBlocks = new ArrayList<>();
    }

    public List<ReserveBlock> findReserveBlocksByDate(LocalDate date) {
        return reserveBlocks.stream()
                            .filter(rb -> rb.getDate().equals(date))
                            .collect(Collectors.toList());
    }

    public List<LocalDate> findDatesForReservedBlock(ReserveBlock targetBlock) {
        return reserveBlocks.stream()
                            .filter(rb -> rb.equals(targetBlock))
                            .map(ReserveBlock::getDate)
                            .collect(Collectors.toList());
    }

    public List<ReserveBlock> getAllReserveBlocks() {
        return new ArrayList<>(reserveBlocks);
    }

    public void addReserveBlock(ReserveBlock reserveBlock) {
        reserveBlocks.add(reserveBlock);
    }

    public boolean removeReserveBlock(ReserveBlock reserveBlock) {
        return reserveBlocks.remove(reserveBlock);
    }

    public List<ReserveBlock> findReservedBlocksAt(LocalDate date) {
        return findReserveBlocksByDate(date);
    }

    public List<ReserveBlock> findReservedBlocksByPerson(Person person) {
        return reserveBlocks.stream()
                            .filter(rb -> rb.getBy().equals(person))
                            .collect(Collectors.toList());
    }

    public List<ReserveBlock> findReservedBlocksByRoom(Room room) {
        return reserveBlocks.stream()
                            .filter(rb -> rb.getRoom().equals(room))
                            .collect(Collectors.toList());
    }
}
