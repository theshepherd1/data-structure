package bp;

import java.util.ArrayList;
import java.util.Collections;

import bp.Index;
import java.util.List;

public class Maze extends AbstractMaze {

	public Maze(int[][] pGrid) {
		super(pGrid);
		this.grid[0][0] = 0;
		this.grid[pGrid.length - 1][pGrid[0].length - 1] = 2;
	}

	public Maze(int[][] pGrid, Index<Integer> pStart, Index<Integer> pFinish) {
		super(pGrid, pStart, pFinish);
		this.grid[start.getRow()][start.getCol()] = 0;
		this.grid[finish.getRow()][finish.getCol()] = 2;
	}
	
	public Maze(int[][] pGrid, int startNum, int finishNum) {
		super(pGrid, startNum, finishNum);
		this.grid[start.getRow()][start.getCol()] = 0;
		this.grid[finish.getRow()][finish.getCol()] = 2;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getAStarPath() {
		closedList.add(numberedGrid[start.getRow()][start.getCol()]);
		List<Integer> pathList = new ArrayList<Integer>();
		pathList.add(numberedGrid[start.getRow()][start.getCol()]);
		PotentialPath potentialPath = new PotentialPath(pathList, getFCost(pathList), 0);
		paths.add(potentialPath);

		while (!paths.isEmpty()) {
			Collections.sort(paths);
			// System.out.println(paths.get(0).getPotentialPath());
			potentialPath = paths.remove(0);
			int currentNum = potentialPath.getPotentialPath().get(potentialPath.getPotentialPath().size() - 1);
			int cRow = getRow(currentNum);
			int cCol = getColumn(currentNum);
			closedList.add(numberedGrid[cRow][cCol]);
			pathList = potentialPath.getPotentialPath();

			if (grid[cRow][cCol] == 2) {
				System.out.println("Found");
				return pathList;
			}
			if (!isWallUp(currentNum) && !closedList.contains(numberedGrid[cRow - 1][cCol])) {
				pathList = potentialPath.getPotentialPathCopy();
				pathList.add(numberedGrid[cRow - 1][cCol]);
				PotentialPath newPP = new PotentialPath(pathList, getFCost(pathList), hCost[cRow - 1][cCol]);
				paths.add(newPP);
			}
			if (!isWallDown(currentNum) && !closedList.contains(numberedGrid[cRow + 1][cCol])) {
				pathList = potentialPath.getPotentialPathCopy();
				pathList.add(numberedGrid[cRow + 1][cCol]);
				PotentialPath newPP = new PotentialPath(pathList, getFCost(pathList), hCost[cRow + 1][cCol]);
				paths.add(newPP);
			}
			if (!isWallLeft(currentNum) && !closedList.contains(numberedGrid[cRow][cCol - 1])) {
				pathList = potentialPath.getPotentialPathCopy();
				pathList.add(numberedGrid[cRow][cCol - 1]);
				PotentialPath newPP = new PotentialPath(pathList, getFCost(pathList), hCost[cRow][cCol - 1]);
				paths.add(newPP);
			}
			if (!isWallRight(currentNum) && !closedList.contains(numberedGrid[cRow][cCol + 1])) {
				pathList = potentialPath.getPotentialPathCopy();
				pathList.add(numberedGrid[cRow][cCol + 1]);
				PotentialPath newPP = new PotentialPath(pathList, getFCost(pathList), hCost[cRow][cCol + 1]);
				paths.add(newPP);
			}
			System.out.println(PotentialPath.getInstancesCreated());
		}

		return paths.isEmpty() ? new ArrayList() : paths.get(0).getPotentialPath();
	}

	private boolean isWallUp(int pCurrent) {
		int r = getRow(pCurrent);
		int c = getColumn(pCurrent);
		if (r - 1 >= 0 && grid[r - 1][c] != -1) {
			return false;
		}
		return true;
	}

	private boolean isWallDown(int pCurrent) {
		int r = getRow(pCurrent);
		int c = getColumn(pCurrent);
		if (r + 1 <= rows - 1 && grid[r + 1][c] != -1) {
			return false;
		}
		return true;
	}

	private boolean isWallLeft(int pCurrent) {
		int r = getRow(pCurrent);
		int c = getColumn(pCurrent);
		if (c - 1 >= 0 && grid[r][c - 1] != -1) {
			return false;
		}
		return true;
	}

	private boolean isWallRight(int pCurrent) {
		int r = getRow(pCurrent);
		int c = getColumn(pCurrent);
		if (c + 1 <= columns - 1 && grid[r][c + 1] != -1) {
			return false;
		}
		return true;
	}

}
