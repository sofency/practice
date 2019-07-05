
int sum(int *arr, int below, int high)
{
	if (below == high)
	{
		return arr[below];
	}
	else if (below + 1 == high)
	{
		return arr[below] + arr[high];
	}
	else
	{
		int mid = (high + below) / 2;
		return sum(arr, below, mid) + sum(arr, mid + 1, high);
	}
}